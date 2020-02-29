package lesson_3;

import java.util.List;

public class Task2 {

    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Ivanov", "123456789");
        myPhoneBook.add("Petrov", "234567891");
        myPhoneBook.add("Ivanov", "345678912");

        List<String> phoneIvanov = myPhoneBook.getPhoneByName("Ivanov");
        System.out.println("Телефоны Иванова: " + phoneIvanov);

        List<String> phonePetrov = myPhoneBook.getPhoneByName("Petrov");
        System.out.println("Телефоны Петрова: " + phonePetrov);
    }
}
