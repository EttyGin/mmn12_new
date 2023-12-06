
public abstract class BankAccount {
    protected String num;
    protected String owner;
    protected String id;
    protected double balance;

    public BankAccount(String num, String name, String id, double balance) {
        this.num = num;
        this.owner = name;
        this.id = id;
        this.balance = balance;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNum() {
        return this.num;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getID() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalBalance {
        try {
            // If there is enough money, subtract the amount from the balance.
            if (this.balance >= amount) {
                this.balance -= amount;
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
        return "Account status:\n\tNumber: " + this.num + "\n\towner: " + this.owner + "\n\tID: " + this.id
        + "\n\taccount Balance: "
        + this.balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount other = (BankAccount) obj;

            return other.num.equals(this.num) && other.owner.equals(this.owner)
            && other.id.equals(this.id) && other.balance == this.balance;
        }

        return false;
    }
}
