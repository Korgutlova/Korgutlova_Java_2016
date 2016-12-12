package com.korgutlova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends GUI {

    private static ClientThread server;

    public Server(){
        super();
    }
    public void SendButtonActionPerformed(ActionEvent evt) {
        getChatArea().setText(
                getChatArea().getText() + "\nMe: " + getTextArea().getText()
        );
        server.getPrintWriter().println(getTextArea().getText());
        getTextArea().setText("");

    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            try {
                ServerSocket ss = new ServerSocket(PORT);
                Server s = new Server();
                Socket socket = ss.accept();
                s.getChatArea().setText("The connection is established. Communicate!\n");
                server = new ClientThread(socket, s);
                server.start();
                s.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}