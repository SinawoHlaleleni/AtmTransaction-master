package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Topup;
import org.junit.Assert;
import org.junit.Test;

public class TopupFactoryTest {

    @Test
    public void getType() {

        Topup s = TopupFactory.getType("SMS");
        System.out.println(s);
        Assert.assertNotNull(s.getType());
    }
}