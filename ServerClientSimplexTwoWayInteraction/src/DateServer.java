import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    private static final int PORT = 5000;
    private static String[] names = {"Wily", "Felix", "Carlsbad", "Hobob"};
    private static  String[] adjs = {"the gentle", "the un-gentle", "the overwrought","the cruel"};
    public static void main(String[] args) throws IOException {
        // Server socket to listen to client connections on a particular port
        ServerSocket listener = new ServerSocket(PORT);

        System.out.println("[SERVER] Waiting for client to connect.....");
        // listen to any connect connections and accept the connection to the server
        Socket client = listener.accept();
        System.out.println("[SERVER] Client Connected!");

        // server will send a message to the client. Input is the form of a stream.
        // So use printwriter class to create  a output stream from the
        // server to the client
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        // client sends message.
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        try{
            while (true){
                String request = in.readLine();
                if (request.contains("name")){
                    System.out.println(request);
                    out.println(getRandomString());
                }else{
                    out.println("Type 'tell me a name' to get a random name");
                }
            }
        }
        catch (Exception e){
            System.out.println("Exception Occured " + e);
        }
        finally {
            client.close();
            listener.close();
        }
        //System.out.println("[SERVER] Sent date. Closing Connection now!!");
        // close all socket connections
    }
    // Method to select random name and adjective
    public static String getRandomString()
    {
        String name = names[(int) (Math.random()*names.length)];
        String adj = adjs[(int) (Math.random() * adjs.length)];

        return name + " " + adj;
    }

}
