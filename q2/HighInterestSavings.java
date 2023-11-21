package q2;

public class HighInterestSavings extends SavingAccount {

    private final static double DEF_HIGH_INTEREST_RATE = 0.06; // לבדוק האם צריך או שיורש מהקודם
    private final static double DEF_HIGH_MIN_BALANCE = 200;
    private double _minBalance;

    public HighInterestSavings(String num, String name, String id, double balance) {
        super(num, name, id, balance, DEF_HIGH_INTEREST_RATE);
        _minBalance = DEF_HIGH_MIN_BALANCE;
    }

    public HighInterestSavings(String num, String name, String id, double balance, double minBalance) {
        super(num, name, id, balance, DEF_HIGH_INTEREST_RATE);
        _minBalance = minBalance;
    }

    public double getMinBalance() {
        return _minBalance;
    }

    public void setMinBalance(double minBalance) {
        _minBalance = minBalance;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\taccount minimum balance: " + _minBalance;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HighInterestSavings) {
            HighInterestSavings other = (HighInterestSavings) obj;
            return super.equals(other) && other._minBalance == _minBalance;
        }
        return false;
    }
}