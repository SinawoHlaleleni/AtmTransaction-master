package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Airtime;
import org.junit.Assert;
import org.junit.Test;

public class AirtimeFactoryTest {

    @Test
    public void getAmount() {
        Airtime s = AirtimeFactory.getAmount(15.00);
        System.out.println(s);
        Assert.assertNotNull(s.gettAmount());
    }
}