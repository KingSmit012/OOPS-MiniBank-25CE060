public interface InterestBearing {

    double interestRate();

    default double yearlyInterest(){
        return interestRate() * ((Account)this).getBalance();
    }
}
