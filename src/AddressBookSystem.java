public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        // Create an instance of AddressBook and perform operations
        AddressBook addressBook = new AddressBook();

        // Example: Creating a new contact using console input
        Contact newContact = new Contact();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        newContact.setFirstName(scanner.nextLine());

        System.out.print("Enter last name: ");
        newContact.setLastName(scanner.nextLine());

        addressBook.addContact(newContact);
        addressBook.displayContacts();

        // Edit an existing contact
        System.out.print("Enter the first name of the contact to edit: ");
        String editFirstName = scanner.nextLine();

        System.out.print("Enter the last name of the contact to edit: ");
        String editLastName = scanner.nextLine();

        addressBook.editContact(editFirstName, editLastName);

        // Display updated contacts
        System.out.println("Contacts in the address book after editing:");
        addressBook.displayContacts();

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
