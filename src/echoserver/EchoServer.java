package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
  public static final int portNumber = 6013;

  ServerSocket sock = new ServerSocket(portNumber);

  while(true) {
    Socket client = sock.accept();
    System.out.println("Got a request!");

    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

    writer.println(new java.util.Date().toString());

    client.close();

  }

  catch (IOException ioe) {
    System.out.println("We caught an unexpected exception");
    System.err.println(ioe);
  }
}
