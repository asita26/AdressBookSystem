import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> contacts; // Use ArrayList to dynamically store contacts

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println("Contact #" + (i + 1) + ":");
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Address: " + contact.getAddress());
            System.out.println("City: " + contact.getCity());
            System.out.println("State: " + contact.getState());
            System.out.println("Zip: " + contact.getZip());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("------------------------");
        }
    }

    public void editContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                // Found the contact, now prompt for edits
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter new first name: ");
                contact.setFirstName(scanner.nextLine());

                System.out.print("Enter new last name: ");
                contact.setLastName(scanner.nextLine());

                System.out.print("Enter new address: ");
                contact.setAddress(scanner.nextLine());

                System.out.print("Enter new city: ");
                contact.setCity(scanner.nextLine());

                System.out.print("Enter new state: ");
                contact.setState(scanner.nextLine());

                System.out.print("Enter new zip: ");
                contact.setZip(scanner.nextLine());

                System.out.print("Enter new phone number: ");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.print("Enter new email: ");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }

    public void deleteContact(String firstName, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName) && contacts.get(i).getLastName().equals(lastName)) {
                contacts.remove(i); // Use remove method to delete contact
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }
}
