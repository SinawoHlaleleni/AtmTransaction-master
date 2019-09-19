package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Atm;
import org.junit.Assert;
import org.junit.Test;

public class AtmFactoryTest {

    @Test
    public void getType() {
        Atm s = AtmFactory.getType("ABSA");
        System.out.println(s);
        Assert.assertNotNull(s.getType());
    }
}