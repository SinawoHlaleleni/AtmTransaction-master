package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Savings;
import org.junit.Assert;
import org.junit.Test;

public class SavingsFactoryTest {

    @Test
    public void getAmount() {
        Savings s = SavingsFactory.getAmount(20.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}