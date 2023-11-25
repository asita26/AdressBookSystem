// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.List;

public class AddressBookSystem {
    private List<Contact> contacts;

    public AddressBookSystem() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {

    }



    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        // Create an instance of AddressBookSystem and perform operations
        AddressBookSystem addressBook = new AddressBookSystem();

        // Example: Creating a new contact
        Contact newContact = new Contact();
        newContact.setFirstName("Asita");
        newContact.setLastName("M");

        // Setting other contact details
        addressBook.addContact(newContact);


        for (Contact contact : addressBook.contacts) {
            System.out.println(contact.getFirstName() + " " + contact.getLastName());
            // Display other contact details
        }
    }
}
