package q2;

public class InterestChecking extends NoServiceChargeChecking {

    private final double DEF_INTEREST_RATE = 0.05;
    private double _interestRate;

    public InterestChecking(String num, String name, String id, double balance) {
        super(num, name, id, balance);
        _interestRate = DEF_INTEREST_RATE;
    }

    public InterestChecking(String num, String name, String id, double balance, double rate) {
        super(num, name, id, balance);
        _interestRate = rate;
    }

    public double getInterestRate() {
        return _interestRate;
    }

    public void setInterestRate(double rate) {
        _interestRate = rate;
    }

    public double calculateInterest() {
        return _balance * _interestRate;
    }

    @Override
    public void monthlyManagement() {
        deposit(calculateInterest());
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tinterest rate: " + _interestRate;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterestChecking) {
            InterestChecking other = (InterestChecking) obj;
            return super.equals(other) && other._interestRate == _interestRate;
        }
        return false;
    }

}
