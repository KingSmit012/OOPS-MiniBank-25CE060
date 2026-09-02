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

    public account(String ownerName){
        this(ownerName ,0);
    }

    public void deposit(long amount){
        if(amount > 0){
            balance += amount;
        }
        else{
            System.out.println("Amount must be positive.");
            return;
        }
    }

    public boolean withdraw(long amount){
        if((amount >0) &&  (balance >= amount)){
            balance = balance - amount;
            return true;
        }
        else{
            System.out.println("Invalid Amount.");
            return false;
        }
            
    }

    String getOwnerName(){
        return this.ownerName;
    }
    String getAccountNumber(){
        return this.accountNumber;
    }
    long getBalance(){
        return this.balance;
    }

    @Override
    public String toString() {
        return "| " +accountNumber + " | " + ownerName +" | Balance: " + balance + " |";
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(!(o instanceof account)){
            return false;
        }

        account other = (account) o;

        return accountNumber.equals(other.accountNumber);
    }
    @Override
    public int hashCode(){
        return accountNumber.hashCode();
    }
}