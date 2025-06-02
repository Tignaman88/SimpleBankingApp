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
        String bankUserFullName;

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
                        while (isUserInArrayList) {
                            System.out.println(bankUserFirstName + " " + bankUserLastName);
                            for (BankUser bankUserObject : bankUsers) {
                                if (bankUserObject.getFirstName().equalsIgnoreCase(bankUserFirstName) && bankUserObject.getLastName().equalsIgnoreCase(bankUserLastName)) {
                                    isMatchFound = true;
                                    System.out.println("Match Found!");
                                    isUserInArrayList = false;
                                    break;
                                }
                            }
                            if (!isMatchFound) {
                                System.out.println("Match Not Found! Please enter your first and last name again: ");
                                isFirstName = true;
                                isUserInArrayList = false;
                            } else {
                                bankUserFullName = bankUserFirstName + bankUserLastName;
                                
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


