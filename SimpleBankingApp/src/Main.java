import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Create an object
        BankUser AlessioScarpello = new BankUser("Alessio", "Scarpello", 2458.24);

        // Create input variable to be used to deposit or withdraw
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Please enter D to deposit, or W to withdraw money from your account: ");
        String moneyInput;
        double moneyToDeposit;
        double moneyToWithdraw;
        boolean isDepositOrWithdraw = true;
        boolean isNumeric = true;
        while (isDepositOrWithdraw) {
            String userInput = scanner.nextLine();
            if (!userInput.equalsIgnoreCase("d") && !userInput.equalsIgnoreCase("w")) {
                System.out.println("You have not selected the right option, please try again: ");
            } else if (userInput.equalsIgnoreCase("d")) {
                System.out.println("Great! How much you'd like to deposit? ");

                // Check if money input by user is a number
                while (isNumeric) {
                    moneyInput = scanner.nextLine();
                    if (!isNumeric(moneyInput)) {
                        System.out.println("You have not selected a valid number, please try again: ");
                    } else {
                        moneyToDeposit = Double.parseDouble(moneyInput);
                        AlessioScarpello.deposit(AlessioScarpello.accountMoney, moneyToDeposit);
                        System.out.println("Hello " + AlessioScarpello.getFirstName() + ", here's your updated balance:" +
                                "£" + AlessioScarpello.getAccountMoney());
                        isNumeric = false;
                    }
                }

                isDepositOrWithdraw = false;
            } else if (userInput.equalsIgnoreCase("w")) {
                System.out.println("Great! How much you'd like to withdraw?");

                // Check if money input by user is a number
                while (isNumeric) {
                    moneyInput = scanner.nextLine();
                    if (!isNumeric(moneyInput)) {
                        System.out.println("You have not selected a valid number, please try again: ");
                    } else {
                        moneyToWithdraw = Double.parseDouble(moneyInput);
                        AlessioScarpello.withdraw(AlessioScarpello.accountMoney, moneyToWithdraw);
                        System.out.println("Hello " + AlessioScarpello.getFirstName() + ", here's your updated balance: " +
                                "£" + AlessioScarpello.getAccountMoney());
                        isNumeric = false;
                    }
                }

                isDepositOrWithdraw = false;
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


