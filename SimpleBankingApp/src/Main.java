import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Create an object
        BankUser Alessio = new BankUser("Alessio", "Scarpello", 2458.24);

        // Create input variable to be used to deposit or withdraw
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Please enter D to deposit, or W to withdraw money from your account: ");
        String userInput = scanner.nextLine();
        double moneyInput = Double.parseDouble(userInput);
        Alessio.deposit(Alessio.accountMoney, moneyInput);
        System.out.println("Hello " + Alessio.getFirstName() + ", you have now " +
                "£" + Alessio.accountMoney + " into your account");
        System.out.println("Hello! Please enter the amount you'd like to withdraw: ");
        while (true) {
            userInput = scanner.nextLine();
            moneyInput = Double.parseDouble(userInput);
            if (Alessio.withdraw(Alessio.accountMoney, moneyInput)) {
                System.out.println("You cannot withdraw more than what you have, please try again: ");
            } else {
                System.out.println("Hello " + Alessio.getFirstName() + ", you have " +
                        "£" + Alessio.accountMoney + " remaining into your account.");
                break;
            }
        }


    }

    public static boolean isNumeric(String userInput) {
        try {
            Double.parseDouble(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


