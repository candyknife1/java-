package server.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import server.parser.Parser;
import server.config.ConfigFile;
import server.thread.StudentServer;

public class SimpleServer {
    public void run() {
        ServerSocket server = null;
        Socket socketS = null;
        InetAddress iaddress = null;
        int port = 4330;
        String requestStr, responseStr;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started waiting for request...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
               socketS = server.accept(); 
                Runnable stuServer=new StudentServer(socketS);
                Thread thd=new Thread(stuServer);
                thd.start();
               
             } catch (IOException e) {
                e.printStackTrace();
                }
        }
    }
    private String getResponseStr(String requestStr){
    Parser par=new Parser();
          return par.run(requestStr);
    }
}
