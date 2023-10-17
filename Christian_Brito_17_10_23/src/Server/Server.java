package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // used to allocate a server
    private static ServerSocket server;
    // used to manage the connection with the client
    private static Socket socket;
    // receive the data of the client
    private static BufferedReader input;
    // send the data to the client
    private static PrintWriter output;

    public static void main(String[] args) {
        try{
            // allocate the server and the number port
            server = new ServerSocket(8180);
            while(true){
                // accept the connection request from the client
                socket = server.accept();
                // used to receive the data(String in this case) from the client
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // used to give back an answer
                output = new PrintWriter(socket.getOutputStream(),true);
                //returns to the client the (String) the personalized greeting
                output.println("Ciao super "+input.readLine());
                // When the service is over, close the connection witch the client
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
