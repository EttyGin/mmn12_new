package q2;

public abstract class BankAccount {
    protected String _num;
    protected String _owner;
    protected String _id;
    protected double _balance;

    public BankAccount(String num, String name, String id, double balance) {
        _num = num;
        _owner = name;
        _id = id;
        _balance = balance;
    }

    public void setNum(String num) {
        _num = num;
    }

    public void setOwner(String owner) {
        _owner = owner;
    }

    public void setID(String id) {
        _id = id;
    }

    public void setBalance(int balance) {
        _balance = balance;
    }

    public String getNum() {
        return _num;
    }

    public String getOwner() {
        return _owner;
    }

    public String getID() {
        return _id;
    }

    public double getBalance() {
        return _balance;
    }

    public void deposit(double amount) {
        _balance += amount;
    }

    public void withdraw(double amount) throws IllegalBalance {
        try {
            // If there is enough money, subtract the amount from the balance.
            if (_balance >= amount) {
                _balance -= amount;
            } else {
                // If there is not enough money, throw an exception.
                throw new IllegalBalance("The balance is not sufficient to perform the withdrawal.");
            }
        } catch (IllegalBalance e) {
            // Handle the exception.
            System.out.println(e.getMessage());
        }
    }

    public abstract void monthlyManagement() throws Exception;

    @Override
    public String toString() {
        return "Account status:\n\tNumber: " + _num + "\n\towner: " + _owner + "\n\tID: " + _id
                + "\n\taccount Balance: "
                + _balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount other = (BankAccount) obj;

            return other._num.equals(_num) && other._owner.equals(_owner)
                    && other._id.equals(_id) && other._balance == _balance;
        }

        return false;
    }
}
