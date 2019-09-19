package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Check;
import org.junit.Assert;
import org.junit.Test;

public class CheckFactoryTest {

    @Test
    public void getAmount() {
        Check s = CheckFactory.getAmount(300.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}