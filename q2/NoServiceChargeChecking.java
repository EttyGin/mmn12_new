 

public class NoServiceChargeChecking extends CheckingAccount {

    private final double DEF_MIN_BALANCE = 200;
    private double minBalance;

    public NoServiceChargeChecking(String num, String name, String id, double balance) {
        super(num, name, id, balance);
        this.minBalance = DEF_MIN_BALANCE;
    }

    public NoServiceChargeChecking(String num, String name, String id, double balance, double min) {
        super(num, name, id, balance);
        this.minBalance = min;
    }

    @Override
    public void monthlyManagement() {
    }

    public void setMinBalance(double min) {
        this.minBalance = min;
    }

    public double getMinBalance() {
        return this.minBalance;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tminimum withdraw :" + this.minBalance;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NoServiceChargeChecking) {
            NoServiceChargeChecking other = (NoServiceChargeChecking) obj;
            return super.equals(other) && other.minBalance == this.minBalance;
        }
        return false;
    }

}
