public class Main {

    public static void main(String[] args) {

        BankUser Alessio = new BankUser("Alessio", "Scarpello", 2458.24);


        Alessio.deposit(Alessio.getAccountMoney(), 2000);

        System.out.println(Alessio.getAccountMoney());
        Alessio.withdraw(Alessio.getAccountMoney(), 6000);
        System.out.println(Alessio.getAccountMoney());


    }
}
