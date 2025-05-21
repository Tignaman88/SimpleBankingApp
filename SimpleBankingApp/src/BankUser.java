public class BankUser extends BankingApp {

    String firstName;
    String lastName;
    double accountMoney;

    public BankUser(String firstName, String lastName, double accountMoney) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accountMoney = accountMoney;
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
