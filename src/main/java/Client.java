import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;
        try (Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            readAndPrint(in);
            writeAndPrint("Irina", out);
            readAndPrint(in);
            writeAndPrint("no", out);
            readAndPrint(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndPrint(BufferedReader in) throws IOException {
        String receivedMessage = in.readLine();
        System.out.println(receivedMessage);
    }

    private static void writeAndPrint(String message, PrintWriter out) {
        out.println(message);
        System.out.printf("Written: %s\n", message);
    }
}