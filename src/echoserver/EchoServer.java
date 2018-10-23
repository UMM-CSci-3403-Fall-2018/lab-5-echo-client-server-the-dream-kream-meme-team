package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
  public static final int portNumber = 6013;


  public static void main(String [] args) {

	try
	{
      ServerSocket sock = new ServerSocket(portNumber);
      while (true) {
        Socket client = sock.accept();
        System.out.println("Got a request!");

	//input from the client
        InputStream in = client.getInputStream();

	//output from the client
        OutputStream out = client.getOutputStream();
	
	//while loop that keeps getting the output from client and sends it back it stops when there is nothing to read
        int tmpByte;
        while((tmpByte = in.read()) != -1) {
          out.write(tmpByte);

        }
        //Close's the client socket when we are done.
        client.close();

      }

}

    catch(IOException ioe){
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}
