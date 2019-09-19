package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Statement;
import org.junit.Assert;
import org.junit.Test;

public class StatementFactoryTest {

    @Test
    public void getStatement() {
       // String type = "Monthly";
        Statement a = StatementFactory.getType("Monthly");
        System.out.println(a);
        Assert.assertNotNull(a.getId());

    }
}