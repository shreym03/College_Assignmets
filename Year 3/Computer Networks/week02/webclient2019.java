
/*
  Computer Network
  Week 2
 
  @author Shrey Mathur 
  @since 28/1/19
 */

import java.net.*;
import java.io.*;

public class webclient2019 {
    public static void main(String[] args) throws Exception {
        String inputLine;
        String host = "www.martinbroadhurst.com"; // URL of the server
        int portnumber = 80; // Address of the web server
        Socket client = new Socket(host, portnumber);
        /*
         * connection between client socket and server socket established. Attach a
         * PrintWriter outputbuffer to HTTP. Headers line by line rather than character
         * by character
         */
        PrintWriter outToSocket = new PrintWriter(client.getOutputStream(), true);
        // Attach an input buffer to read serial character from socket and
        BufferedReader InFromSocket = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outToSocket.println("Get / HTTP/1.1");// first http request header sent
        outToSocket.println("Host: www.martinbroadhurst.com"); // second http header sent
        outToSocket.println(); // send blank header
        while ((inputLine = InFromSocket.readLine()) != null) {
            System.out.println(inputLine);
        }
        client.close();
        System.exit(1);
    }
}
