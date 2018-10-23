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
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

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
