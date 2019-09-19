package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Fixed;
import org.junit.Assert;
import org.junit.Test;

public class FixedFactoryTest {

    @Test
    public void getAmount() {
        Fixed s = FixedFactory.getAmount(500.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}