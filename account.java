public class account {

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean isActive;

    private static int accountCounter = 1;

    public account(String ownerName , long initialBalance){
        this.accountNumber = String.format("AC%04d",(accountCounter++));
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.isActive = true;
    }

    String getAccountNumber(){
        return this.accountNumber;
    }
    String getownerName(){
        return this.ownerName;
    }
    long getBalance(){
        return this.balance;
    }
}