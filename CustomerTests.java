import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CustomerTests {
    @Test
    public void testCustomerDepositChecking () {
        Customer newCustomer = new Customer("Ted", 12345, 0.0, 0.0);
        double checkingDeposit = newCustomer.deposit(400.0, new Date(), Customer.CHECKING);
        assertEquals(Double.valueOf(checkingDeposit), Double.valueOf(400.0));
    }
    @Test
    public void testCustomerDepositSaving () {
        Customer newCustomer = new Customer("Ted", 11111, 0.0, 0.0);
        double savingDeposit = newCustomer.deposit(500.0, new Date(), Customer.SAVING);
        assertEquals(Double.valueOf(savingDeposit), Double.valueOf(500.0));
    }

    @Test
    public void testCustomerWithdrawChecking () {
        Customer newCustomer = new Customer("Ted", 12345, 400.0, 0.0);
        double checkingWithdraw = newCustomer.withdraw(200.0, new Date(), Customer.CHECKING);
        assertEquals(Double.valueOf(checkingWithdraw), Double.valueOf(200.0));
    }
    @Test
    public void testCustomerWithdrawSaving () {
        Customer newCustomer = new Customer("Ted", 11111, 0.0, 500.0);
        double savingWithdraw = newCustomer.withdraw(300.0, new Date(), Customer.SAVING);
        assertEquals(Double.valueOf(savingWithdraw), Double.valueOf(200.0));
    }

    @Test
    public void testCustomerWithdrawCheckingOverdraft () {
        Customer newCustomer = new Customer("Ted", 12345, 400.0, 0.0);
        double checkingWithdraw = newCustomer.withdraw(800.0, new Date(), Customer.CHECKING);
        assertEquals(Double.valueOf(checkingWithdraw), Double.valueOf(400.0));
    }

    @Test
    public void testCustomerWithdrawSavingOverdraft () {
        Customer newCustomer = new Customer("Ted", 11111, 0.0, 500.0);
        double savingWithdraw = newCustomer.withdraw(800.0, new Date(), Customer.SAVING);
        assertEquals(Double.valueOf(savingWithdraw), Double.valueOf(500.0));
    }
}
