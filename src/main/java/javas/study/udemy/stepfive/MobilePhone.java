package javas.study.udemy.stepfive;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContacts(Contacts contacts) {
        if (findContact(contacts.getName()) >= 0) {
            System.out.println("Contacts is already on file");
            return false;
        }

        return myContacts.add(contacts);
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contacts contacts) {
        int foundPosition = findContact(contacts);
        if (foundPosition < 0) {
            System.out.println(contacts.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(contacts);
        System.out.println(contacts.getName() + " was deleted.");
        return true;
    }
    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacts contacts = myContacts.get(i);
            if (contacts.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contacts) {
        if (findContact(contacts) >= 0) {
            return contacts.getName();
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) return myContacts.get(position);
        return null;
    }
}
