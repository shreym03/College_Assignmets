/*
  Week 5
  Load an image 
  @author Shrey Mathur 
  @since 18/02/2019
 */

import java.net.*;
import java.io.*;

public class HTTPURLUsage {
    public static void main(String[] args) throws Exception {
        URL urlObject = new URL("https://www.bits-pilani.ac.in/Uploads/Campus/BITS_Dubai_campus_logo.gif");
        // Make use of high level java network api to hide complexities of programming
        // at basic socket level
        HttpURLConnection newConnection = (HttpURLConnection) urlObject.openConnection();
        newConnection.connect();
        /*
         * Connection is getting established Http request headers sent Http response
         * headers and image started receiving
         */
        String httpResponse = newConnection.getResponseMessage();
        System.out.println(httpResponse);
        System.out.println("GET or POST:" + newConnection.getRequestMethod());
        System.out.println("Content Length: " + newConnection.getContentLength());
        // open an input stream to read image bytes
        File file_dest = new File("C:\\Users\\Dell\\Documents\\CompNet2018-2019\\download.gif");
        int length;
        // open an output stream to file write image bytes got by HttpURLConnection
        OutputStream toFile = new FileOutputStream(file_dest);
        byte[] image_buffer = new byte[2048];
        // open an input stram to newConnection object ( which represents a connection
        // between client and server) to receive blocks of bytes corresponding to pixels
        // of the image incrementally
        InputStream fromServer = newConnection.getInputStream();
        // read first block of data from server and store and repeat the same until
        // there is no more data
        while ((length = fromServer.read(image_buffer)) != -1) {
            toFile.write(image_buffer, 0, length); // now write block of data from image_buffer to file
        }
        fromServer.close();
        toFile.close();
    }
}
