public class BankUser extends BankingApp {

    String firstName;
    String lastName;
    double accountMoney;

    public BankUser(String firstName, String lastName, double accountMoney) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountMoney = accountMoney;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney) {
        this.accountMoney = accountMoney;
    }


    public void deposit(double accountMoney, double moneyToDeposit) {
        this.accountMoney = accountMoney + moneyToDeposit;

    }

    @Override
    public boolean withdraw(double accountMoney, double moneyToWithdraw) {
        this.accountMoney = accountMoney - moneyToWithdraw;
        return accountMoney < 0;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountMoney=" + accountMoney +
                "} " + super.toString();
    }
}
