package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String [] args) throws IOException,UnknownHostException {
        Socket socket= new Socket(InetAddress.getLocalHost(), ServerSegment.PORT);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        printWriter.println("New Segment");
        printWriter.println(Double.toString(0.0));
        printWriter.println(Double.toString(0.0));
        printWriter.println(Double.toString(4.0));
        printWriter.println(Double.toString(4.0));

        String result= bufferedReader.readLine();

        System.out.println(result);

        printWriter.println("Simmetric");
        printWriter.println(Double.toString(0.0));
        printWriter.println(Double.toString(4.0));

        String x= bufferedReader.readLine();
        String y= bufferedReader.readLine();
        System.out.println(x + y);

        printWriter.println("END");

        socket.close();
    }
}
