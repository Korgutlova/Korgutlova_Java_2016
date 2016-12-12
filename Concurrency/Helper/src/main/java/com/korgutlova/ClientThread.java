package com.korgutlova;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket;
    private ChatWindow client;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    public ClientThread(Socket s, ChatWindow j) throws IOException {
        this.socket = s;
        this.client = j;
        this.bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.printWriter = new PrintWriter(s.getOutputStream(), true);
    }

    public void run() {
        try {
            String s;
            JTextArea jta = client.getChatArea();
            while (true) {
                s = bufferedReader.readLine();
                jta.setText(jta.getText() + "\nYour friend: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

}