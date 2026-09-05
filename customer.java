public class Customer implements Cloneable {
    private String name;
    private String email;
    private String mobileNumber;

    private final String CustomerId;

    private static long CustomerCounter = 100;

    private Address address;


    private static String generateCustomerId(long n) {
        return "CUST" + n;
    }

    public Customer(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;

        CustomerCounter++;
        CustomerId = generateCustomerId(CustomerCounter);
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    String getMobileNumber() {
        return mobileNumber;
    }

    String getCustomerID() {
        return CustomerId;
    }

    // Added for Practical 3
    public static class Address {
        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }

    // Added for Practical 3
    public void setAddress(Address address) {
        this.address = address;
    }

    // Added for Practical 3
    public Address getAddress() {
        return address;
    }

    @Override
    public String toString(){
        return address.line + " , "+ address.city + " - " + address.pincode;
    }

    // Added for Practical 3
    @Override
    public Customer clone() {
        try {
            return (Customer) super.clone();
        } 
        catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}