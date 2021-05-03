/*
  Computer Network Week 1
  Emulate a simple connection
 
  @author Shrey Mathur
  @since 21/1/2019
 */

import java.net.*;
import java.io.*;

public class WebClient {
    public static void main(String[] args) throws IOException {

        // Create a clientSocket to connect to server socket of google
        Socket client = new Socket();
        String host = "www.google.com";
        PrintWriter s_out = null;
        /*
         * Sending HTTP request as a line from the program and get converting it into
         * character by character for sending ihe client socket
         */
        /*
         * connect Google serversocket using IP address and port number public void
         * connect(SocketAddress endpoint);
         */
        client.connect(new InetSocketAddress(host, 80));

        // Attach the printwriter to client socket
        s_out = new PrintWriter(client.getOutputStream(), true);
        System.out.println("Connected to socket of google");
        String FirstHTTPRequest = "GET / 1.1\r\n";
        String SecondReq = "Host: www.google.com\r\n\r\n";
        s_out.println(FirstHTTPRequest);
        s_out.println(SecondReq); // Done with Request
        System.out.println("HTTP headers sent from client to server socket of google");
        client.close();
    }
}
