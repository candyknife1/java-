package server.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import server.parser.Parser;
import server.config.ConfigFile;

public class StudentServer implements Runnable{
Socket socket=null;
 public StudentServer(Socket socket){
   this.socket=socket;
 } 
  
  public void service(){
   try{
     DataInputStream in = new DataInputStream(socket.getInputStream());
     DataOutputStream out = new DataOutputStream(socket.getOutputStream());

     String requestStr = in.readUTF();
     System.out.println("server get message:" + requestStr);
                 
                
      String responseStr=getResponseStr(requestStr);
      out.writeUTF(responseStr);

       in.close();
       out.close();
     }catch(IOException e){
         e.printStackTrace();
       }

  }
  
 private String getResponseStr(String requestStr){
   
   String source="file";
   ConfigFile cf=new ConfigFile();
   source=cf.getSource();
   Parser par=new Parser();
   return par.run(source);

  }

  public void run(){
    service();
}

  

}