package lesson_4;

import javax.swing.*;
import java.awt.*;

public class ChatWindow {

    private final String[] users = {"User_1", "User_2", "User_3"};
    private JPanel panel;
    private JList<String> userList;
    private JTextArea chat;
    private JTextField text;
    private JButton button;

    public void init() {
        JFrame frame = new JFrame("Chat Window");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        this.userList.setListData(users);
        this.chat.setFont(new Font("Verdana", Font.ITALIC, 14));
        this.initListener();
        frame.add(panel);
        frame.setVisible(true);
    }

    private void initListener() {
        this.button.addActionListener(actionEvent -> addMessageToChat());
        this.text.addActionListener(actionEvent -> addMessageToChat());
    }

    private void addMessageToChat() {
        String textValue = text.getText().trim();
        if (textValue.isEmpty()) {
            return;
        }
        String user = userList.getSelectedValue();
        String message = getMessage(user, textValue);
        chat.append(message);
        text.setText(null);
    }

    private String getMessage(String user, String textValue) {
        String message;
        if (user != null) {
            message = "@" + user + ": ";
        } else {
            message = "я: ";
        }
        return message + textValue + "\n";
    }
}
