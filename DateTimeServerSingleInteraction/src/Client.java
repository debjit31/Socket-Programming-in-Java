import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
    private static final int SERVER_PORT = 9090;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String serverresponse = input.readLine();

        JOptionPane.showMessageDialog(null, serverresponse);

        socket.close();
        System.exit(0);
    }

}
