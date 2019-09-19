package ATMtrans.factory.factoryCardless;

import ATMtrans.domain.cardless.Ewallet;
import org.junit.Assert;
import org.junit.Test;

public class EwalletFactoryTest {

    @Test
    public void getAmount() {

        Ewallet s = EwalletFactory.getAmount(500.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}