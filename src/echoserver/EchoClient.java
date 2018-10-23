
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
<<<<<<< HEAD
      //This will send out what ever we write to the outputstream
      OutputStream out = socket.getOutputStream();
      // what ever input we get from the standard input will be in this
      InputStream bytes = System.in;
        //this will also get the input stream from the socket so that we can read from it.
            InputStream reader = socket.getInputStream();

            while ((int i = bytes.read()) != -1) {
                out.write(i);
                int in = reader.read();
                System.out.write(in);
        }

            socket.close();

            System.out.flush();


        }
=======

      //getting ready to read from the socket
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
      BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

      //send text to server
      String line = userInput.readLine();
      writer.println(line);


      //Recieving text from the Server
	    while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      //close socket when done reading from it
      socket.close();
    }
>>>>>>> 1bf0e205c9865d55051a9c8a38fa506562516674
     catch (ConnectException ce) {
      System.out.println("We were unable to connect to " + server);
      System.out.println("You should make sure the server is running.");
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }

  }

}
