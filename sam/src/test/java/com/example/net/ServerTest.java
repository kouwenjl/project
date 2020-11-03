package com.example.net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket socket=serverSocket.accept();
        InputStream inputStream=socket.getInputStream();
        byte[] data=new byte[1024];
        int readLength=0;
        while (true) {
            while ((readLength = inputStream.read(data)) > 0) {
                System.out.println(new String(data,0,readLength));
            }
        }
    }
}
