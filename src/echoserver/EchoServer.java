import java.net.*;
import java.io.*;

public class Server {
  public static final int portNumber = 6013;


  public static void main(String [] args) {
    try {
      ServerSocket sock = new ServerSocket(portNumber);
      while (true) {
        Socket client = sock.accept();
        System.out.println("Got a request!");
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        String line = in.readLine();
        //Send data back to client
        out.println(line);



      }
    }
    catch(IOException ioe){
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}
