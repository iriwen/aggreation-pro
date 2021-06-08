package com.manjaro.code.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created by iriwen on 2020/06/16.
 */
public class BIOSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8090);
        System.out.println("Server listen port 8090");
        while (true) {
            Socket client = server.accept();
            System.out.println("client  connected ,port:" + client.getPort());

            new Thread(new Runnable() {
                 /*Socket ss;
                 public Runnable setSocket(Socket s){
                     ss = s;
                     return this;
                 }*/
                @Override
                public void run() {
                    try {
                        InputStream in = client.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        while (true){
                            String line = reader.readLine();
                            System.out.println("line :" + line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
