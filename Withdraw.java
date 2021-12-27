import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the information properly formatted
    public String toString(){
        return "Withdraw of: $" + this.amount +  " Date: " + this.date + " from account: " + this.account;
    }
}
