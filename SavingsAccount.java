public class SavingsAccount extends account{
    
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
    public boolean canWithdraw(long amount){
        
        if(amount > minBalance){
            return true;
        }
        return false;
    }
}
