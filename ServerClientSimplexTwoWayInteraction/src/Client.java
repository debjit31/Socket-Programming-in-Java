import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        //  use printwriter for output and bufferedreader for input
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        try{
            while (true) {
                System.out.println("> ");
                String command = keyboard.readLine();
                if (command.equals("quit"))
                    break;
                else{
                    out.println(command);
                    String serverresponse = input.readLine();
                    System.out.println("Server Says :- " + serverresponse);
                }
            }
        }finally {
            socket.close();
            System.exit(0);
        }

    }
}
