public class customer implements Cloneable {
    private String name;
    private String email;
    private String mobileNumber;

    private final String customerId;

    private static long customerCounter = 100;

    private Address address;


    private static String generateCustomerId(long n) {
        return "CUST" + n;
    }

    public customer(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;

        customerCounter++;
        customerId = generateCustomerId(customerCounter);
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
        return customerId;
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
    public customer clone() {
        try {
            return (customer) super.clone();
        } 
        catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}