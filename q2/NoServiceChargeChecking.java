package q2;

public class NoServiceChargeChecking extends CheckingAccount {

    private final double DEF_MIN_BALANCE = 200;
    private double _minBalance;

    public NoServiceChargeChecking(String num, String name, String id, double balance) {
        super(num, name, id, balance);
        _minBalance = DEF_MIN_BALANCE;
    }

    public NoServiceChargeChecking(String num, String name, String id, double balance, double min) {
        super(num, name, id, balance);
        _minBalance = min;
    }

    @Override
    public void monthlyManagement() {
    }

    public void setMinBalance(double min) {
        _minBalance = min;
    }

    public double getMinBalance() {
        return _minBalance;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tminimum withdraw :" + _minBalance;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NoServiceChargeChecking) {
            NoServiceChargeChecking other = (NoServiceChargeChecking) obj;
            return super.equals(other) && other._minBalance == _minBalance;
        }
        return false;
    }

}
