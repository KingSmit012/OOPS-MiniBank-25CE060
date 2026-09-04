public class FixedDepositAccount extends account{

    public FixedDepositAccount(String ownerName , long initialBalance){
        super(ownerName, initialBalance);
    }

    @Override
    public double interestRate(){
        return 7.0;
    }

    @Override
    public boolean canWithdraw(long amount){
        return false;
    }
}
