package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    // used to make a request to the client
    private static Socket socket;
    // receive the data of the client
    private static BufferedReader input;
    // send the data to the client
    private static PrintWriter output;
    public static void main(String[] args) {
        try{
            // accept the connection request from the client
            socket = new Socket("localHost",8180);

            // used to receive the data(String) from the client
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // used to receive the data(String) from the client
            output = new PrintWriter(socket.getOutputStream(),true);
            // Sends the client name to the server
            output.println("Nara");
            // prints the server response
            System.out.println(input.readLine());
            // When the service is over, close the connection witch the client
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
