 

public class SavingAccount extends BankAccount {

    protected static final double DEF_INTEREST_RATE = 0.05;
    protected double interestRate;

    public SavingAccount(String num, String name, String id, double balance) {
        super(num, name, id, balance);
         this.interestRate = DEF_INTEREST_RATE;
    }

    public SavingAccount(String num, String name, String id, double balance, double rate) {
        super(num, name, id, balance);
         this.interestRate = rate;
    }

    public double getInterestRate() {
        return  this.interestRate;
    }

    public void setInterestRate(double rate) {
         this.interestRate = rate;
    }

    public double calculateInterest() {
        return  this.balance *  this.interestRate;
    }

    @Override
    public void monthlyManagement() {
        deposit(calculateInterest());
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tinterest rate: " +  this.interestRate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SavingAccount) {
            SavingAccount other = (SavingAccount) obj;
            return super.equals(other) && other.interestRate ==  this.interestRate;
        }
        return false;
    }

}