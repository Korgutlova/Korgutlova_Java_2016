package com.korgutlova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;

public class Client extends ChatWindow {

    private static ClientThread client;

    public Client(){
        super();
    }
    public void SendButtonActionPerformed(ActionEvent evt) {
        getChatArea().setText(
                getChatArea().getText() + "\nMe: " + getTextArea().getText()
        );
        client.getPrintWriter().println(getTextArea().getText());
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
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            try {
                Socket socket = new Socket(HOST, PORT);
                Client c = new Client();
                c.getChatArea().setText("The connection is established. Communicate!\n");
                client = new ClientThread(socket, c);
                client.start();
                c.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}