package lesson_3;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Ivanov", "123456789");
        myPhoneBook.add("Petrov", "234567891");
        myPhoneBook.add("Ivanov", "345678912");
        myPhoneBook.add("Sidorov", "956487897");

        Set<String> phoneIvanov = myPhoneBook.getPhoneByName("Ivanov");
        System.out.println("Телефоны Иванова: " + phoneIvanov);

        Set<String> phonePetrov = myPhoneBook.getPhoneByName("Petrov");
        System.out.println("Телефоны Петрова: " + phonePetrov);

        Set<String> phoneSidorov = myPhoneBook.getPhoneByName("Sidorov");
        System.out.println("Телефоны Сидорова: " + phoneSidorov);
    }
}
