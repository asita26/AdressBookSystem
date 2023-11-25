public class AddressBook
{
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
    }

}
