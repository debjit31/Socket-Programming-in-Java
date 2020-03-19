import com.sun.source.tree.Scope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // server input :- Welcome Message
        String serverMessage = in.readLine();
        System.out.println(serverMessage);
        try{
            while (true){
                String s = input.readLine();
                if (s.equals("stop")){
                    out.println(s);
                    break;
                }
                else{
                    out.println(s);
                }
            }
        }finally {
            socket.close();
        }


    }

}
