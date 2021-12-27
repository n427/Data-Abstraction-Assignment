import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class DepositTests {
    @Test
    public void testDepositChecking () {
        // Date(int year, int month, int date, int hrs, int min, int sec)
        Deposit newDeposit = new Deposit(400, new Date(2018 - 1900, Calendar.NOVEMBER, 4, 0, 0, 0), Customer.CHECKING);
        assertEquals("Deposit of: $400.0 Date: Sun Nov 04 00:00:00 PDT 2018 into account: Checking", newDeposit.toString());
    }
    @Test
    public void testDepositSaving () {
        Deposit newDeposit = new Deposit(500, new Date(2018 - 1900, Calendar.AUGUST, 16, 10, 52, 17), Customer.SAVING);
        assertEquals("Deposit of: $500.0 Date: Thu Aug 16 10:52:17 PDT 2018 into account: Saving", newDeposit.toString());
    }
}
