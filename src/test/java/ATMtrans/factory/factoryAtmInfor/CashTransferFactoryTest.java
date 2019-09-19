package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.CashTransfer;
import org.junit.Assert;
import org.junit.Test;

public class CashTransferFactoryTest {

    @Test
    public void getAmount() {
        CashTransfer s = CashTransferFactory.getAmount(15.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
    }
