import java.util.Scanner;

public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        // Create an instance of AddressBook
        AddressBook addressBook = new AddressBook();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Loop to allow users to enter multiple contacts
        while (true) {
            // Example: Creating a new contact using console input
            Contact newContact = new Contact();

            System.out.print("Enter first name: ");
            newContact.setFirstName(scanner.nextLine());

            System.out.print("Enter last name: ");
            newContact.setLastName(scanner.nextLine());

            System.out.print("Enter address: ");
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

            // Add the new contact to the address book
            addressBook.addContact(newContact);

            System.out.print("Do you want to add another contact? (yes/no): ");
            String addAnother = scanner.nextLine().toLowerCase();

            if (!addAnother.equals("yes")) {
                break; // Exit the loop if the user doesn't want to add another contact
            }
        }

        // Display all contacts in the address book
        System.out.println("Contacts in the address book:");
        addressBook.displayContacts();


        while (true) {
            System.out.print("Enter the first name of the contact to edit (or type 'exit' to finish editing): ");
            String editFirstName = scanner.nextLine();

            if (editFirstName.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user chooses to stop editing
            }

            System.out.print("Enter the last name of the contact to edit: ");
            String editLastName = scanner.nextLine();

            addressBook.editContact(editFirstName, editLastName);

            // Display updated contacts
            System.out.println("Contacts in the address book after editing:");
            addressBook.displayContacts();
        }
        // Delete an existing contact
        System.out.print("Enter the first name of the contact to delete: ");
        String deleteFirstName = scanner.nextLine();

        System.out.print("Enter the last name of the contact to delete: ");
        String deleteLastName = scanner.nextLine();

        addressBook.deleteContact(deleteFirstName, deleteLastName);

        // Display updated contacts
        System.out.println("Contacts in the address book after deleting:");
        addressBook.displayContacts();
    }
}
