import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class WithdrawTests {
    @Test
    public void testWithdrawChecking () {
        Withdraw newWithdraw = new Withdraw(400, new Date(2018 - 1900, Calendar.NOVEMBER, 4, 0, 0, 0),Customer.CHECKING);
        assertEquals("Withdraw of: $400.0 Date: Sun Nov 04 00:00:00 PDT 2018 from account: Checking", newWithdraw.toString());
    }
    @Test
    public void testWithdrawSaving () {
        Withdraw newWithdraw = new Withdraw(500, new Date(2018 - 1900, Calendar.AUGUST, 16, 10, 52, 17),Customer.SAVING);
        assertEquals("Withdraw of: $500.0 Date: Thu Aug 16 10:52:17 PDT 2018 from account: Saving", newWithdraw.toString());
    }
}
