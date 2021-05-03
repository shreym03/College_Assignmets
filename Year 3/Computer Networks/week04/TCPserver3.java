
/*
  Computer Network Week 4 Creating server
  
  @author Shrey
  @version 04/02/2019
 */

import java.io.*;
import java.net.*;

class TCPServer3 {
    public static void main(String[] args) throws IOException {
        // Open a server socket which listens via port number 6969
        ServerSocket serversocket = new ServerSocket(23); // welcome
        System.out.println("Server socket in");
        Socket Toclient = serversocket.accept();
        // Blocking call to wait for incoming connections from client
        // For Incoming connection from client, open Input stream and Output stream to
        // Toclient obj to send or recieve info
        System.out.println("Client got connected");
        BufferedReader FromClient = new BufferedReader(new InputStreamReader(Toclient.getInputStream()));
        PrintWriter SendClient = new PrintWriter(Toclient.getOutputStream());
        while (true) {
            String ReadData = FromClient.readLine(); // read a line of data from client
            // Display the readData in server console
            System.out.println(ReadData);
            String modified = ReadData.toUpperCase();
            SendClient.println(modified);
            SendClient.flush();

        }
    }
}
