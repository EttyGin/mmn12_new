 

public class ServiceChargeChecking extends CheckingAccount {

    private static final double MONTHLY_FEE = 10;
    private double monthlyFeeSum;

    public ServiceChargeChecking(String num, String name, String id, double balance) {
        super(num, name, id, balance);
        this.monthlyFeeSum = MONTHLY_FEE;
    }

    public ServiceChargeChecking(String num, String name, String id, double balance, double fee) {
        super(num, name, id, balance);
         this.monthlyFeeSum = fee;
    }

    @Override
    public void monthlyManagement() throws Exception {
        withdraw(this.monthlyFeeSum);
    }

    public void setFeeSum(double sum) {
         this.monthlyFeeSum = sum;
    }

    public double getFeeSum() {
        return this.monthlyFeeSum;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tmonthly fee: " +  this.monthlyFeeSum;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ServiceChargeChecking) {
            ServiceChargeChecking other = (ServiceChargeChecking) obj;
            return super.equals(other) && other.monthlyFeeSum == this.monthlyFeeSum;
        }
        return false;
    }

}
