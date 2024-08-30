import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            String clientMessage;

            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                out.println("Echo: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected...");
            new ClientHandler(clientSocket).start();
        }
    }
}

// Client Code
public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = keyboard.readLine()) != null) {
            output.println(userInput);
            System.out.println(input.readLine());
        }
    }
}
