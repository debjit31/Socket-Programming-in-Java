import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket  listener = new ServerSocket(PORT);

        System.out.println("[SERVER] Waiting for client to JOin.....");
        Socket client = listener.accept();
        System.out.println("[SERVER] Client Connected....");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        out.println("[SERVER] Welcome to the Server");
        try{
            while (true){
                String req = in.readLine();
                if(req.equals("stop")){
                    break;
                }else{
                    System.out.println(req);
                }
            }
        }catch (Exception np){
            System.out.println("Exception Occured :- " + np);
        }
        finally {
            System.out.println("[SERVER] Message Sent.. Now Ending Connection...");
            listener.close();
            client.close();
        }





    }
}
