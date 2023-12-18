package client.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SimpleClient {
    private String ip;
    private int port;
    private String requestStr;

    public SimpleClient(String ip, int port, String requestStr) {
        this.ip = ip;
        this.port = port;
        this.requestStr = requestStr;
    }

    public String run() {
        try (Socket socketC = new Socket(ip, port);
             DataOutputStream out = new DataOutputStream(socketC.getOutputStream());
             DataInputStream in = new DataInputStream(socketC.getInputStream())) {

            System.out.println("Connecting OK!");
            out.writeUTF(requestStr);
            System.out.println("Send message: " + requestStr);
            String responseStr = in.readUTF();
            System.out.println("Receive message: " + responseStr);
            return responseStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "None";
    }
}
