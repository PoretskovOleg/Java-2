package lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static Scanner scanner = new Scanner(System.in);
    private static final int PORT = 8080;
    private static final String END_COMMAND = "close";

    private static Socket socket;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {

        try {
            openConnection();
            Thread threadRead = new Thread(() -> readMessage());
            Thread threadWrite = new Thread(() -> writeMessage());
            threadRead.start();
            threadWrite.start();
            threadRead.join();
            threadWrite.interrupt();
            closeConnection();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void openConnection() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен");

        socket = serverSocket.accept();
        System.out.println("Клиент подключился");

        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());

        outputStream.writeUTF("Соединение установлено");
    }

    private static void closeConnection() {
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
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

    private static void writeMessage() {
        try {
            while (true) {
                String message = scanner.nextLine();
                if (message.equals(END_COMMAND)) {
                    break;
                }
                outputStream.writeUTF("Cервер: " + message);
            }
        } catch (IOException e) {
            System.out.println("Клиент отключился");
        }
    }
}
