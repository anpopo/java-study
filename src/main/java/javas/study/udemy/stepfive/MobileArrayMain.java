package javas.study.udemy.stepfive;

import java.util.Scanner;

public class MobileArrayMain {

    private final static Scanner sc = new Scanner(System.in);
    private final static MobilePhone mobilePhone = new MobilePhone("01026369914");
    public static void main(String[] args) {
        boolean quit = false;

        startPhone();
        printAction();
        while (!quit) {
            System.out.println("\nEnter action : (6 to show available actions)");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;
            }
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name : " + existingContact.getName() + " / Phone number : " + existingContact.getPhoneNumber());
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContact)){
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }


    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new phone number: ");
        String newNumber = sc.nextLine();

        Contacts newContact = Contacts.createContacts(newName, newNumber);

        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated record.");
        } else System.out.println("Error updating record.");
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sc.nextLine();

        Contacts newContact = Contacts.createContacts(name, phone);
        if (mobilePhone.addNewContacts(newContact)) {
            System.out.println("New contact added.");
        } else System.out.println("Cannot add, " + name + " already on file.");
    }

    private static void startPhone() {
        System.out.println("Starting phone....");
    }

    private static void printAction() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print a list of available actions.");
        System.out.println("Choose your actions :  ");

    }
}
