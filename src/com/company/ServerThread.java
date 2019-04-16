package com.company;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket connectedSocket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public ServerThread(Socket socket) throws IOException {
        connectedSocket= socket;
        bufferedReader= new BufferedReader(new InputStreamReader(connectedSocket.getInputStream()));
        printWriter= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        start();
    }

    public void run(){
        String input;
        String x1,x2,y1,y2,x,y;
        Segment segment= new Segment();

        while(true){
            try {
                input = bufferedReader.readLine();
                if(input.equals("END"))
                {
                    break;
                }
                if(input.equals("NewSegment")){
                    x1= bufferedReader.readLine();
                    y1= bufferedReader.readLine();
                    x2= bufferedReader.readLine();
                    y2= bufferedReader.readLine();
                    Point primo= new Point(Double.parseDouble(x1),Double.parseDouble(y1));
                    Point secondo = new Point(Double.parseDouble(x2),Double.parseDouble(y2));
                    boolean risultato=segment.set(primo,secondo);

                    if(risultato)
                        printWriter.println("       OK");
                    else
                        printWriter.println("       KO");
                }
                if(input.equals("Simmetric")){
                    x= bufferedReader.readLine();
                    y= bufferedReader.readLine();
                    Point point= new Point(Double.parseDouble(x),Double.parseDouble(y));
                    Point ps= segment.simmetric(point);
                    System.out.println(""+x+y);
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        try {
            connectedSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

