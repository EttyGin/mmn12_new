 

public abstract class CheckingAccount extends BankAccount {

    public CheckingAccount(String num, String name, String id, double balance) {
        super(num, name, id, balance);
    }

    public void writeCheck(double amount) throws Exception {
        if (balance < amount)
            throw new IllegalBalance("Unsuficiant funds for check");
        else
            balance -= amount;
    }
}
