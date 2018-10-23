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
<<<<<<< HEAD
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        while((int i = in.read()) != -1) {
          out.write(i);
        }
        //Close's the client socket when we are done.
        client.close();
=======
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter writer = new PrintWriter(client.getOutputStream(),true);

        //String line = in.readLine();
        String line;
>>>>>>> 1bf0e205c9865d55051a9c8a38fa506562516674

        writer.println("Here!");

        while ((line = in.readLine()) != null) {
          writer.println("now here!");
          writer.println(line);
        }

      }

}

    catch(IOException ioe){
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}
