package com.example.net;

import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws Exception{
        try {
            Socket socket=new Socket("localhost",8080);
            socket.getOutputStream().write("sss".getBytes());
        }catch (Exception e){

        }
        System.gc();
        System.out.println();
    }
}
