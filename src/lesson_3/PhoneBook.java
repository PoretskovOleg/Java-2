package lesson_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, String> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phone) {
        this.phonebook.put(phone, name);
    }

    public List<String> getPhoneByName(String name) {
        List<String> phones = new LinkedList<>();

        for (Map.Entry<String, String> phone  : this.phonebook.entrySet()) {
            if ( name.equals(phone.getValue()) ) {
                phones.add(phone.getKey());
            }
        }

        return phones;
    }
}
