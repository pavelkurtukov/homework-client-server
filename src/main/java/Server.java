import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8855;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

                    System.out.println("Соединение установлено");
                    final String name = reader.readLine();
                    writer.println(String.format("Получено сообщение \"%s\" с порта %d", name, clientSocket.getPort()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
