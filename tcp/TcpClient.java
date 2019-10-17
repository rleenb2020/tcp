import java.io.*;
import java.net.*;

public class TcpClient {
  private static final String HOST_ADDRESS = "127.0.0.1";
  private static final int PORT = 6789;

  public static void main(String[] args) throws IOException {
    Socket socket = new Socket(HOST_ADDRESS, PORT);
    DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
    BufferedReader serverBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    System.out.println("Please enter a message to send.");
    BufferedReader userBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String userInput = userBufferedReader.readLine();
    outToServer.writeBytes(userInput + '\n');

    String responseFromServer = serverBufferedReader.readLine();
    System.out.println("Response from server: " + responseFromServer);

    socket.close();
  }
}
