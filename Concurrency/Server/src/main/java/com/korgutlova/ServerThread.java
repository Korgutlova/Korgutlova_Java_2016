package com.korgutlova;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

class ServerThread extends Thread{
    private Socket socket;
    private Server server;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    public ServerThread(Socket s, Server j) throws IOException {
        this.socket = s;
        this.server = j;
        this.bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.printWriter = new PrintWriter(s.getOutputStream(), true);
    }
    public void run (){
        try {
            String s;
            JTextArea jta = server.getChatArea();
            while (true) {
                s = bufferedReader.readLine();
                jta.setText(jta.getText() + "\nYour friend: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrintWriter getPrintWriter(){
        return printWriter;
    }

}