import java.util.jar.Attributes.Name;

import javax.swing.text.JTextComponent.KeyBinding;

public class customer {
    private String name;
    private String email;
    private String mobileNumber;

    private final String customerId;

    private static long customerCounter = 100;

    private static String generateCustomerId(long n){
        return  "H3KR" + customerCounter;
    }

    public customer(String name , String email , String mobileNumber){
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;

        customerCounter = customerCounter +1;

        customerId = generateCustomerId(customerCounter);
    }

    String getName(){
        return name;
    }
    String getEmail(){
        return email;
    }
    String getMobileNumber(){
        return mobileNumber;
    }
    String getCustomerID(){
        return customerId;
    }
}