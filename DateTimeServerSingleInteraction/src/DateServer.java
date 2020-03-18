import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Date;

public class DateServer {

    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        ServerSocket listener = new ServerSocket(PORT);


        System.out.println("[SERVER] Waiting for client .....");
        Socket client = listener.accept();
        System.out.println("[SERVER] Connected to Client!!!!");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println((new Date()).toString() );

        System.out.println("[SERVER] sent date..  closing connection !!");
        listener.close();
        client.close();

    }

}
