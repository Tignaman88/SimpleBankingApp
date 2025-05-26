public class BankUser extends BankingApp {

    String firstName;
    String lastName;
    double accountMoney;

    public BankUser(String firstName, String lastName, double accountMoney) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountMoney = accountMoney;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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


    public boolean withdraw(double accountMoney, double moneyToWithdraw) {
        if (moneyToWithdraw < accountMoney) {
            this.accountMoney = accountMoney - moneyToWithdraw;
        }
        return moneyToWithdraw > accountMoney;
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
