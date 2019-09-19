package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Flexible;
import org.junit.Assert;
import org.junit.Test;

public class FlexibleFactoryTest {

    @Test
    public void getAmount() {
        Flexible s = FlexibleFactory.getAmount(800.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());

    }
}