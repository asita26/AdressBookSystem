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
        for (int i = 0; i < numContacts; i++) {
            Contact contact = contacts[i];
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
        for (int i = 0; i < numContacts; i++) {
            if (contacts[i].getFirstName().equals(firstName) && contacts[i].getLastName().equals(lastName)) {
                // Shift remaining elements after the deleted contact
                for (int j = i; j < numContacts - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }
                contacts[numContacts - 1] = null; // Set the last element to null
                numContacts--;

                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }
}

