package com.korgutlova;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends JFrame {

    private static ServerThread server;
    private static final int PORT = 3456;
    private JTextArea chatArea;
    private JButton deleteButton;
    private JButton sendButton;
    private JTextArea textArea;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JTextArea getChatArea() {
        return chatArea;
    }

    public Server() {
        initComponents();
    }

    private void initComponents() {
        createButtons();
        createTextAreas();
        createScrollPanes();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        setHorizontalGroup(layout);
        setVerticalGroup(layout);
        pack();
    }

    private void createButtons() {
        sendButton = new JButton();
        deleteButton = new JButton();

        sendButton.setBackground(new Color(102, 204, 0));
        sendButton.setText("Send");
        sendButton.addActionListener(this::SendButtonActionPerformed);

        deleteButton.setBackground(new Color(255, 102, 102));
        deleteButton.setText("Remove");
        deleteButton.addActionListener(this::DeleteButtonActionPerformed);
    }

    private void createScrollPanes() {
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jScrollPane1.setViewportView(chatArea);
        jScrollPane2.setViewportView(textArea);
    }

    private void createTextAreas() {
        chatArea = new JTextArea();
        textArea = new JTextArea();

        chatArea.setColumns(20);
        chatArea.setRows(5);
        chatArea.setEditable(false);

        textArea.setColumns(20);
        textArea.setRows(5);
    }

    private void setHorizontalGroup(GroupLayout layout) {
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(sendButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deleteButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(78, Short.MAX_VALUE))
        );
    }

    private void setVerticalGroup(GroupLayout layout) {
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2))
                                .addGap(57, 57, 57))
        );
    }

    private void SendButtonActionPerformed(ActionEvent evt) {
        chatArea.setText(
                chatArea.getText() + "\nMe: " + textArea.getText()
        );
        server.getPrintWriter().println(textArea.getText());
        textArea.setText("");

    }

    private void DeleteButtonActionPerformed(ActionEvent evt) {
        textArea.setText("");
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            try {
                ServerSocket ss = new ServerSocket(PORT);
                Server s = new Server();
                Socket socket = ss.accept();
                s.getChatArea().setText("The connection is established. Communicate!\n");
                server = new ServerThread(socket, s);
                server.start();
                s.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}