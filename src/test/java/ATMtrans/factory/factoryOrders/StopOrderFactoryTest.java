package ATMtrans.factory.factoryOrders;

import ATMtrans.domain.orders.StopOrder;
import org.junit.Assert;
import org.junit.Test;

public class StopOrderFactoryTest {

    @Test
    public void getAmount() {

        StopOrder s = StopOrderFactory.getAmount(0.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}