 

public class TesterBank {

    public static void main(String[] args) throws Exception {
        // Create bank accounts
        BankAccount[] bank = {
                new SavingAccount("01", "David", "035711111", 150000),
                new SavingAccount("02", "Moshe", "035758111", 0),
                new ServiceChargeChecking("03", "Sarah", "035789999", 12350),
                new ServiceChargeChecking("04", "Esther", "039855555", 1000),
                new NoServiceChargeChecking("05", "Yaakov", "032575555", 45200),
                new NoServiceChargeChecking("06", "Roni", "045231111", 350),
                new HighInterestSavings("07", "Etty", "065232222", 200),
                new HighInterestSavings("08", "Emuna", "012352222", 1500),
                new InterestChecking("09", "Dani", "032541233", 1000000),
                new InterestChecking("10", "Yishay", "041254777", 0) };

        // Display account details
        System.out.println("**Account details before performing any operations:**");
        for (BankAccount account : bank) {
            System.out.println(account);
        }

        // Perform random deposits and withdrawals
        for (int i = 0; i < bank.length; i++) {
            int amount = (int) (Math.random() * 100000);
            if (Math.random() > 0.5) {
                bank[i].deposit(amount);
            } else {
                bank[i].withdraw(amount);
            }
        }

        // Display account details after performing deposits and withdrawals
        System.out.println("**Account details after performing deposits and withdrawals:**");
        for (BankAccount account : bank) {
            System.out.println(account);
        }

        // Perform monthly management on all accounts
        for (BankAccount account : bank) {
            try {
                account.monthlyManagement();
            } catch (IllegalBalance e) {
                System.out.println(e.getMessage());
            }
        }

        // Display account details after performing monthly management
        System.out.println("**Account details after performing monthly management:**");
        for (BankAccount account : bank) {
            System.out.println(account);
        }
    }
}
