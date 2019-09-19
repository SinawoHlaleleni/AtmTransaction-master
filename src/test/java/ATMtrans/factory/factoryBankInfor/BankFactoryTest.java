package ATMtrans.factory.factoryBankInfor;

import ATMtrans.domain.bankInfor.Bank;
import org.junit.Assert;
import org.junit.Test;

public class BankFactoryTest {

    @Test
    public void getName() {

        Bank s = BankFactory.getName("ABSA");
        System.out.println(s);
        Assert.assertNotNull(s.getName());
    }
}