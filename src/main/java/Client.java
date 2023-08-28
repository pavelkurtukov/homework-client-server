import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8855;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.println("test message");
            String responce = reader.readLine();
            System.out.println("[Client] Ответ от сервера: " + responce);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
