import java.util.Objects;

public class Contact {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phoneNumber;
        private String email;

        // Constructors, if needed

        // Getter and setter methods for firstName
        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        // Getter and setter methods for lastName
        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        // Getter and setter methods for address
        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        // Getter and setter methods for city
        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        // Getter and setter methods for state
        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        // Getter and setter methods for zip
        public String getZip() {
                return zip;
        }

        public void setZip(String zip) {
                this.zip = zip;
        }

        // Getter and setter methods for phoneNumber
        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        // Getter and setter methods for email
        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Contact contact = (Contact) obj;
                return Objects.equals(getFirstName(), contact.getFirstName()) &&
                        Objects.equals(getLastName(), contact.getLastName());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getFirstName(), getLastName());
        }
}



