public class SavingsAccount extends Account{
    
    private long minBalance;

    public SavingsAccount(String ownerName , long initialBalance , long minBalance){
        super(ownerName , initialBalance);
        this.minBalance = minBalance;
    }

    @Override
    public double interestRate(){
        return 4.0;
    }


    @Override
    public boolean canWithdraw(long amount) {
        return getBalance() - amount >= minBalance;
    }

}
