public class CurrentAccount extends Account{
    private long overdraftLimit;

    public CurrentAccount(String ownerName , long initialBalance , long overdraftLimit){
        super(ownerName , initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double interestRate(){
        return 0.0;
    }

    @Override
    public boolean canWithdraw(long amount){
        return getBalance() - amount >= - overdraftLimit;
    }

    public long getoverdraftLimit(){
        return this.overdraftLimit;
    }
}
