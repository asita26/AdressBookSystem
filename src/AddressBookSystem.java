import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {
    private Map<String, AddressBook> addressBooks; // Dictionary to store AddressBooks
    private Scanner scanner;

    public AddressBookSystem() {
        this.addressBooks = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void createAddressBook() {
        System.out.print("Enter the name for the new Address Book: ");
        String addressBookName = scanner.nextLine();

        if (!addressBooks.containsKey(addressBookName)) {
            AddressBook newAddressBook = new AddressBook();
            addressBooks.put(addressBookName, newAddressBook);
            System.out.println("Address Book '" + addressBookName + "' created successfully.");
        } else {
            System.out.println("Address Book with the name '" + addressBookName + "' already exists.");
        }
    }

    public void switchAddressBook() {
        System.out.print("Enter the name of the Address Book you want to switch to: ");
        String addressBookName = scanner.nextLine();

        if (addressBooks.containsKey(addressBookName)) {
            AddressBook currentAddressBook = addressBooks.get(addressBookName);
            manageAddressBook(currentAddressBook);
        } else {
            System.out.println("Address Book with the name '" + addressBookName + "' not found.");
        }
    }

    private void manageAddressBook(AddressBook addressBook) {
        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Switch to another Address Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Add Contact
                    Contact newContact = new Contact();
                    System.out.print("Enter first name: ");
                    newContact.setFirstName(scanner.nextLine());
                    System.out.print("Enter last name: ");
                    newContact.setLastName(scanner.nextLine());
                    System.out.print("Enter Address: ");
                    newContact.setAddress(scanner.nextLine());
                    System.out.print("Enter city: ");
                    newContact.setCity(scanner.nextLine());
                    System.out.print("Enter state: ");
                    newContact.setState(scanner.nextLine());
                    System.out.print("Enter zip: ");
                    newContact.setZip(scanner.nextLine());
                    System.out.print("Enter phone number: ");
                    newContact.setPhoneNumber(scanner.nextLine());
                    System.out.print("Enter email: ");
                    newContact.setEmail(scanner.nextLine());
                    addressBook.addContact(newContact);
                    break;

                case 2:
                    // Display Contacts
                    addressBook.displayContacts();
                    break;

                case 3:
                    // Edit Contact
                    System.out.print("Enter the first name of the contact to edit: ");
                    String editFirstName = scanner.nextLine();
                    System.out.print("Enter the last name of the contact to edit: ");
                    String editLastName = scanner.nextLine();
                    addressBook.editContact(editFirstName, editLastName);
                    break;

                case 4:
                    // Delete Contact
                    System.out.print("Enter the first name of the contact to delete: ");
                    String deleteFirstName = scanner.nextLine();
                    System.out.print("Enter the last name of the contact to delete: ");
                    String deleteLastName = scanner.nextLine();
                    addressBook.deleteContact(deleteFirstName, deleteLastName);
                    break;

                case 5:
                    // Switch to another Address Book
                    return;

                case 6:
                    // Exit
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        while (true) {
            System.out.println("1. Create Address Book");
            System.out.println("2. Switch to Address Book");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = addressBookSystem.scanner.nextInt();
            addressBookSystem.scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addressBookSystem.createAddressBook();
                    break;

                case 2:
                    addressBookSystem.switchAddressBook();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

