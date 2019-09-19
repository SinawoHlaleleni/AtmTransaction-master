package ATMtrans.factory.factoryBankInfor;

import ATMtrans.domain.bankInfor.Branch;
import org.junit.Assert;
import org.junit.Test;

public class BranchFactoryTest {

    @Test
    public void getName() {
        Branch s = BranchFactory.getName("CNR ABSA branch");
        System.out.println(s);
        Assert.assertNotNull(s.getName());

    }
}