public class BankingApp {

    // Simple class that allows a user to withdraw or deposit money to their account


    double balance;

    public void deposit(double accountMoney, double moneyToDeposit) {

        this.balance = accountMoney + moneyToDeposit;
    }

    public boolean withdraw(double accountMoney, double moneyToWithdraw) {

        this.balance = accountMoney - moneyToWithdraw;
        return balance < 0;
    }

}
