package lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final String END_COMMAND = "close";

    private static Scanner scanner = new Scanner(System.in);
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    private static Socket socket;

    public static void main(String[] args) {

        try {
            openConnection();
            Thread threadRead = new Thread(() -> readMessage());
            Thread threadWrite = new Thread(() -> writeMessage());
            threadRead.start();
            threadWrite.start();
            threadWrite.join();
            threadRead.interrupt();
            closeConnection();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void openConnection() throws IOException {
        socket = new Socket(HOST, PORT);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    private static void closeConnection() throws IOException {
        outputStream.close();
        inputStream.close();
        socket.close();
    }

    private static void writeMessage() {
        try {
            while (true) {
                String message = scanner.nextLine();
                if (message.equals(END_COMMAND)) {
                    break;
                }
                outputStream.writeUTF("Клиент: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMessage() {
        try {
            while (true) {
                String response = inputStream.readUTF();
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println("Конец связи");
        }
    }
}
