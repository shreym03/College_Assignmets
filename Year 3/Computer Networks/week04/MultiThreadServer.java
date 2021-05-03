import java.io.*;
import java.net.*;

/**
 * Week 4 Multi-Thread Server
 * 
 * @author Shrey Mathur
 * @since 11/02/2019
 */

// Runnable interface supports run() method
public class MultiThreadServer implements Runnable {
    Socket Toclient;

    public MultiThreadServer(Socket client) {
        Toclient = client;
    }

    // New thread will start executing from run() method
    public void run() {
        // here the code for communication with client using respective connection
        // socket
        try {
            BufferedReader FromClient = new BufferedReader(new InputStreamReader(Toclient.getInputStream()));
            PrintWriter SendClient = new PrintWriter(Toclient.getOutputStream());
            while (true) {
                String ReadData = FromClient.readLine(); // read a line of data from client
                System.out.println(ReadData);
                String modified = ReadData.toUpperCase();
                SendClient.println(modified);
                SendClient.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // Open a welcome server socketand w ait for connection from client
        // for every client who calls accept() method, create a thread to serve him via
        // its connection socket
        ServerSocket welcomesocket = new ServerSocket(6969);
        while (true) {
            // wait for connection from client
            Socket connectionsocket = welcomesocket.accept();
            MultiThreadServer instance1 = new MultiThreadServer(connectionsocket);
            Thread threadforclient = new Thread(instance1);
            // The above server thread will look for run() method with class
            // MultiThreadServer
            threadforclient.start();
            welcomesocket.close();
        }

    }
}
