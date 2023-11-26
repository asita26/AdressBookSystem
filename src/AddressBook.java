import java.util.Scanner;

public class AddressBook {
    private Contact[] contacts;
    private int numContacts;

    public AddressBook() {
        this.contacts = new Contact[50];
        this.numContacts = 0;
    }

    public void addContact(Contact contact) {
        if (numContacts < contacts.length) {
            contacts[numContacts++] = contact;
        } else {
            System.out.println("Address book is full. Cannot add more contacts.");
        }
    }

    public void displayContacts() {
        for (int i = 0; i < numContacts; i++) {
            Contact contact = contacts[i];
            System.out.println(contact.getFirstName() + " " + contact.getLastName());
            // Display other contact details
        }
    }

    public void editContact(String firstName, String lastName) {
        for (int i = 0; i < numContacts; i++) {
            Contact contact = contacts[i];
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                // Found the contact, now prompt for edits
                Scanner scanner = new Scanner(System.in);

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
}
