package q2;

public abstract class CheckingAccount extends BankAccount {

    public CheckingAccount(String num, String name, String id, double balance) {
        super(num, name, id, balance);
    }

    public void writeCheck(double amount) throws Exception {
        if (_balance < amount)
            throw new IllegalBalance("Unsuficiant funds for check");
        else
            _balance -= amount;
        // לבדוק מה לעשות במצב כזה
    }
}
