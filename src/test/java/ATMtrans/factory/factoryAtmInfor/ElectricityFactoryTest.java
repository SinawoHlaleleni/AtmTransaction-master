package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Electricity;
import org.junit.Assert;
import org.junit.Test;

public class ElectricityFactoryTest {

    @Test
    public void getAmount() {
        Electricity s = ElectricityFactory.getAmount(30.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());

    }
}