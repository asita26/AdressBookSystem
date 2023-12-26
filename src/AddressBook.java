import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public Map<String, Long> countContactsByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));
    }

    public Map<String, Long> countContactsByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState, Collectors.counting()));
    }

    public void addContact(Contact contact) {
        if (contacts.stream().noneMatch(existingContact ->
                existingContact.getFirstName().equals(contact.getFirstName()) &&
                        existingContact.getLastName().equals(contact.getLastName()))) {
            contacts.add(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Duplicate entry. Contact not added.");
        }
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
                updateContactDetails(contact);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }

    private void updateContactDetails(Contact contact) {
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
    }

    public void deleteContact(String firstName, String lastName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found with the given name.");
    }

    public void searchByCityOrState(String cityOrState) {
        contacts.stream()
                .filter(contact ->
                        contact.getCity().equalsIgnoreCase(cityOrState) || contact.getState().equalsIgnoreCase(cityOrState))
                .forEach(this::displayContactDetails);
    }

    private void displayContactDetails(Contact contact) {
        System.out.println("Matching Contact:");
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

    public void writeToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("AddressBook written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AddressBook readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (AddressBook) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
