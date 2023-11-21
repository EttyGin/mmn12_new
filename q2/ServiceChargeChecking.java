package q2;

public class ServiceChargeChecking extends CheckingAccount {

    private static final double MONTHLY_FEE = 10;
    private double _monthlyFeeSum;

    public ServiceChargeChecking(String num, String name, String id, double balance) {
        super(num, name, id, balance);
        _monthlyFeeSum = MONTHLY_FEE;
    }

    public ServiceChargeChecking(String num, String name, String id, double balance, double fee) {
        super(num, name, id, balance);
        _monthlyFeeSum = fee;
    }

    @Override
    public void monthlyManagement() throws Exception {
        withdraw(_monthlyFeeSum);
    }

    public void setFeeSum(double sum) {
        _monthlyFeeSum = sum;
    }

    public double getFeeSum() {
        return _monthlyFeeSum;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tmonthly fee: " + _monthlyFeeSum;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ServiceChargeChecking) {
            ServiceChargeChecking other = (ServiceChargeChecking) obj;
            return super.equals(other) && other._monthlyFeeSum == _monthlyFeeSum;
        }
        return false;
    }

}
