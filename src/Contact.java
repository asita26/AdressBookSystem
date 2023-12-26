import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phoneNumber;
        private String email;

        // Constructor
        public Contact(String firstName, String lastName, String address, String city, String state, String zip,
                       String phoneNumber, String email) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.address = address;
                this.city = city;
                this.state = state;
                this.zip = zip;
                this.phoneNumber = phoneNumber;
                this.email = email;
        }

        // Getter and setter methods for all fields...

        @Override
        public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Contact contact = (Contact) obj;
                return Objects.equals(getFirstName(), contact.getFirstName()) &&
                        Objects.equals(getLastName(), contact.getLastName()) &&
                        Objects.equals(getAddress(), contact.getAddress()) &&
                        Objects.equals(getCity(), contact.getCity()) &&
                        Objects.equals(getState(), contact.getState()) &&
                        Objects.equals(getZip(), contact.getZip()) &&
                        Objects.equals(getPhoneNumber(), contact.getPhoneNumber()) &&
                        Objects.equals(getEmail(), contact.getEmail());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getFirstName(), getLastName(), getAddress(), getCity(),
                        getState(), getZip(), getPhoneNumber(), getEmail());
        }

        @Override
        public String toString() {
                return "Contact{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", address='" + address + '\'' +
                        ", city='" + city + '\'' +
                        ", state='" + state + '\'' +
                        ", zip='" + zip + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
