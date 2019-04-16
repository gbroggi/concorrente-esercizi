package com.company;

import java.io.IOException;
import java.net.*;
public class ServerSegment {
    public static final int PORT= 8888;
    public static void main(String[] args)throws IOException {
	// write your code here
        ServerSocket serverSocket= new ServerSocket(PORT);

        while(true){
            Socket socket= serverSocket.accept();
            new ServerThread(socket);
        }
    }
}
