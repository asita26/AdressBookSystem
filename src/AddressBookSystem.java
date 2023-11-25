public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        // Create an instance of AddressBookSystem and perform operations
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
    }
}
