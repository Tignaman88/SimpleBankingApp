import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Create an object
        BankUser AlessioScarpello = new BankUser("Alessio", "Scarpello", 2458.24);
        BankUser MarcoValerio = new BankUser("Marco", "Valerio", 3897.45);
        BankUser CarlaJackson = new BankUser("Carla", "Jackson", 6743.55);

        // Creating an array list that will hold bank users
        ArrayList<BankUser> bankUsers = new ArrayList<>();
        bankUsers.add(AlessioScarpello);
        bankUsers.add(MarcoValerio);
        bankUsers.add(CarlaJackson);




        // Create input variable to be used to deposit or withdraw
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        //System.out.println("Hello! Please enter D to deposit, or W to withdraw money from your account: ");
        String moneyInput;
        double moneyToDeposit;
        double moneyToWithdraw;
        boolean isDepositOrWithdraw = true;
        boolean isNumeric = true;
        boolean isMoreThanAvailableBalance = true;
        boolean isUserInArrayList;
        boolean isFirstName = true;
        boolean isLastName;
        boolean isMatchFound = false;
        // Variable to be used if user is contained in ArrayList
        String bankUserInput;
        String bankUserFirstName;
        String bankUserLastName;
        BankUser bankUserObject = null;

        // Loops that asks user to enter their first and last name
        // Numbers are not accepted
        System.out.println("Hello and welcome! Please enter your first name: ");
        while (isFirstName) {

            bankUserInput = scanner.nextLine();
            if (bankUserInput.matches(".*\\d.*")) {
                System.out.println("You've entered a number, please try again: ");
            } else {
            bankUserFirstName = bankUserInput;
            System.out.println("Thank you! Now please enter your last name: ");
            isFirstName = false;
            isLastName = true;
                while (isLastName) {
                    bankUserInput = scanner.nextLine();
                    if (bankUserInput.matches(".*\\d.*")) {
                        System.out.println("You've entered a number, please try again: ");
                    } else {
                        bankUserLastName = bankUserInput;
                        isLastName = false;
                        isUserInArrayList = true;
                        // Loop that checks if first and last name are matched with object in array list
                        while (isUserInArrayList) {
                            System.out.println(bankUserFirstName + " " + bankUserLastName);
                            for (BankUser object : bankUsers) {
                                if (object.getFirstName().equalsIgnoreCase(bankUserFirstName) && object.getLastName().equalsIgnoreCase(bankUserLastName)) {
                                    isMatchFound = true;
                                    System.out.println("Match Found!");
                                    bankUserObject = object;
                                    isUserInArrayList = false;
                                    break;
                                }
                            }

                            // If match not found, start all over
                            // Else, assign the object to the variable bankUserObject used to deposit or withdraw in that account
                            if (!isMatchFound) {
                                System.out.println("Match Not Found! Please enter your first and last name again: ");
                                isFirstName = true;
                                isUserInArrayList = false;
                            } else {
                                System.out.println("Welcome " + bankUserFirstName + " " + bankUserLastName + "!");
                                System.out.println("What would you like to do? Press D for deposit, or W to withdraw");
                                // Loops that ask user if it wants to deposit or withdraw money
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
                                                // Deposit money into account
                                                moneyToDeposit = Double.parseDouble(moneyInput);
                                                bankUserObject.deposit(bankUserObject.accountMoney, moneyToDeposit);
                                                System.out.println("Hello " + bankUserObject.getFirstName() + ", here's your updated balance: " +
                                                        "£" + bankUserObject.getAccountMoney());
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
                                                // Check if amount withdrawn is bigger than amount available
                                                // If not, go back to above loop
                                                // Else, withdraw money from account
                                                isMoreThanAvailableBalance = true;
                                                while (isMoreThanAvailableBalance) {
                                                    moneyToWithdraw = Double.parseDouble(moneyInput);
                                                    if (bankUserObject.withdraw(bankUserObject.accountMoney, moneyToWithdraw)) {
                                                        System.out.println("You cannot withdraw more than what you have, please try a different amount: ");
                                                    } else {
                                                        System.out.println("Hello " + bankUserObject.getFirstName() + ", here's your updated balance: " +
                                                                "£" + bankUserObject.getAccountMoney());
                                                        isNumeric = false;
                                                    }
                                                    isMoreThanAvailableBalance = false;
                                                }

                                            }
                                        }

                                        isDepositOrWithdraw = false;
                                    }


                                }




                            }

                            }
                    }

                    }
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