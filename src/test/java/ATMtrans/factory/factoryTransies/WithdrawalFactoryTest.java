package ATMtrans.factory.factoryTransies;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.factory.factoryAtmTransies.WithdrawalFactory;
import org.junit.Assert;
import org.junit.Test;

public class WithdrawalFactoryTest {

    @Test
    public void getAmount() {

       Withdrawal s = WithdrawalFactory.getAmount(50.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());

    }
}