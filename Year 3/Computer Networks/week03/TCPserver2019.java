import java.io.*;
import java.net.*;
/**
 * Computer Network
 * Week 3
 * Creating server
 * @author Shrey
 * @version 04/02/2019
 */
public class TCPServer2019  
{
    public static void main(String[] args) throws IOException {
        // Open a server socket which listens via port number 6969
        ServerSocket serversocket = new ServerSocket(6969); //welcome
        Socket Toclient = serversocket.accept(); //Blocking call to wait for incoming connections from client
        //For Incoming connection from client, open Input stream and Output stream to Toclient obj to send or recieve info
        BufferedReader FromClient = new BufferedReader(new InputStreamReader(Toclient.getInputStream()));
        PrintWriter SendClient = new PrintWriter(Toclient.getOutputStream());
        String ReadData = FromClient.readLine(); // read a line of data from client
        // Display the readData in server console
        System.out.println(ReadData);
        String modified = ReadData.toUpperCase();
        SendClient.println(modified);
        SendClient.flush();
    }
}

