package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
  public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;

    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      //connect to sever
      Socket socket = new Socket(server, portNumber);
      //This will send out what ever we write to the outputstream
      OutputStream out = socket.getOutputStream();
      // what ever input we get from the standard input will be in this
      InputStream bytes = System.in;
        //this will also get the input stream from the socket so that we can read from it.
            InputStream reader = socket.getInputStream();
            int tmpByte;
            int outByte;
	    // keeps reading bytes until there is no more lines to be read and sends it to the output.
            while ((tmpByte = bytes.read()) != -1) {
                out.write(tmpByte);
                outByte = reader.read();
                System.out.write(outByte);
        }

	// make sure everything is out of buffers to improve the I/O performance
	System.out.flush();
	// close dat shizz because we don't want it open.
            socket.close();

            


        }

     catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }

  }

}
