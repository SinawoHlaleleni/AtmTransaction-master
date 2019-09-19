package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.CashLimit;
import org.junit.Assert;
import org.junit.Test;

public class CashLimitFactoryTest {

    @Test
    public void getAmount() {

        CashLimit s = CashLimitFactory.getAmount(3000.00);
        System.out.println(s);
        Assert.assertNotNull(s.getId());

    }
}