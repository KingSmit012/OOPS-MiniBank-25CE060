import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

import annotation.Id;
import annotation.Positive;

public abstract class Account implements Transactable, InterestBearing {

    @Id 
    private final String accountNumber;


    private final String ownerName;
    
    @Positive 
    private long balance;
    
    private boolean isActive;

    private static int accountCounter = 1;

    public Account(String ownerName, long initialBalance) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Owner name cannot be empty."
            );
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative."
            );
        }

        this.accountNumber =
                String.format("AC%04d", accountCounter++);

        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.isActive = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    @Override
    public void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance = Math.addExact(balance, amount);
    }

    @Override
    public boolean withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (!canWithdraw(amount)) {
            long available = Math.max(0, balance);
            long shortfall = Math.max(0, amount - available);

            throw new InsufficientFundsException(
                    "Insufficient funds in account " + accountNumber,
                    shortfall
            );
        }

        balance -= amount;
        return true;
    }

    public void transfer(Account to, long amount)
            throws BankException {

        try {
            if (to == null) {
                throw new BankException(
                        "Destination account does not exist."
                );
            }

            if (to == this) {
                throw new BankException(
                        "Cannot transfer money to the same account."
                );
            }

            withdraw(amount);

            to.deposit(amount);

            System.out.println(
                    "Transfer successful: " + amount
                            + " transferred from "
                            + accountNumber + " to "
                            + to.getAccountNumber()
            );

        } catch (BankException e) {
            throw e;

        } finally {
            System.out.println("Transfer operation completed.");
        }
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "| " + accountNumber + " | " + ownerName
                + " | Balance: " + balance + " |";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Account)) {
            return false;
        }

        Account other = (Account) o;
        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}
