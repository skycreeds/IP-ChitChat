package com.example.chitchat;

import java.io.*;
import java.net.Socket;

public class client2 {

    Socket socket;
    DataInputStream reader;
    DataOutputStream writer;
    ClientController controller=new ClientController();
    public client2(Socket socket) throws IOException {
        this.socket=socket;
        this.reader= new DataInputStream(socket.getInputStream());
        this.writer=new DataOutputStream(socket.getOutputStream());
    }

    public  void  DataOut(String data) throws IOException {
        writer.writeUTF(data);
        writer.flush();
    }
    public void IncomingM(){
        new Thread(new Runnable() {
            String buff ="";
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                         buff =buff+"\n"+ reader.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    controller.Label2.setText(buff);

                }

            }
        }

        ).start();
    }

}
