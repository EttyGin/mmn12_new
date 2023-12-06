
public class HighInterestSavings extends SavingAccount {
    private final static double DEF_HIGH_INTEREST_RATE = 0.06;
    private final static double DEF_HIGH_MIN_BALANCE = 200;
    private double minBalance;

    public HighInterestSavings(String num, String name, String id, double balance) {
        super(num, name, id, balance, DEF_HIGH_INTEREST_RATE);
        this.minBalance = DEF_HIGH_MIN_BALANCE;
    }

    public HighInterestSavings(String num, String name, String id, double balance, double minBalance) {
        super(num, name, id, balance, DEF_HIGH_INTEREST_RATE);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return  this.minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\taccount minimum balance: " +  this.minBalance;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HighInterestSavings) {
            HighInterestSavings other = (HighInterestSavings) obj;
            return super.equals(other) && other.minBalance ==  this.minBalance;
        }
        return false;
    }
}