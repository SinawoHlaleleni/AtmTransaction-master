package ATMtrans.factory.factoryOrders;

import ATMtrans.domain.orders.CreditOrder;
import org.junit.Assert;
import org.junit.Test;

public class CreditOrderFactoryTest {

    @Test
    public void getAmount() {

        CreditOrder s = CreditOrderFactory.getAmount(10.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}