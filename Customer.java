import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        this.name = name;
        this.accountNumber = accountNumber;
        deposit(checkDeposit, new Date(), CHECKING);
        deposit(savingDeposit, new Date(), SAVING);
    }
    // Requires: amt, date, account
    // Modifies: deposits, checkBalance, savingBalance
    // Effects: creates a new deposit, adds the deposit to deposits, prints the deposit, adds amt to the correct balance
    public double deposit(double amt, Date date, String account){
        Deposit deposit = new Deposit(amt, date, account);
        deposits.add(deposit);
        System.out.println(deposit);
        if (account.equals(CHECKING)) {
            checkBalance += amt;
            return checkBalance;
        } else if (account.equals(SAVING)) {
            savingBalance += amt;
            return savingBalance;
        }
        return 0;
    }
    // Requires: amt, date, account
    // Modifies: withdraws, checkBalance, savingBalance
    // Effects: creates a new withdraw, removes the withdraw from withdraw, prints the withdraw, takes away amt from the correct balance
    public double withdraw(double amt, Date date, String account){
        Withdraw withdraw = new Withdraw(amt, date, account);
        withdraws.remove(withdraw);
        System.out.println(withdraw);
        if (account.equals(CHECKING)) {
            if(!checkOverdraft(amt, account)) {
                checkBalance -= amt;
            }
            return checkBalance;
        } else if (account.equals(SAVING)) {
            if(!checkOverdraft(amt, account)) {
                savingBalance -= amt;
            }
            return savingBalance;
        }
        return 0;
    }
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING) && checkBalance < amt) {
            return true;
        } else if (account.equals(SAVING) && savingBalance < amt) {
            return true;
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
