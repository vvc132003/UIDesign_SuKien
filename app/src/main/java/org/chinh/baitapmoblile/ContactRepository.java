package org.chinh.baitapmoblile;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    public static List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Chính", "123456789"));
        contacts.add(new Contact("Hải", "123456789"));
        contacts.add(new Contact("Khánh", "123456789"));
        contacts.add(new Contact("Nam", "123456789"));
        contacts.add(new Contact("Duy", "123456789"));
        contacts.add(new Contact("Thầy", "123456789"));
        return contacts;
    }
}
