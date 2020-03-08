package lesson_3;

import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        Set<String> phones = this.getPhoneByName(name);
        phones.add(phone);
        this.phoneBook.put(name, phones);
    }

    public Set<String> getPhoneByName(String name) {
        return this.phoneBook.getOrDefault(name, new HashSet<>());
    }
}
