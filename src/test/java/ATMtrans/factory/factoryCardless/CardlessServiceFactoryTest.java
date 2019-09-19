package ATMtrans.factory.factoryCardless;

import ATMtrans.domain.cardless.CardlessService;
import org.junit.Assert;
import org.junit.Test;

public class CardlessServiceFactoryTest {

    @Test
    public void getType() {

        CardlessService s = CardlessServiceFactory.getType("...");
        System.out.println(s);
        Assert.assertNotNull(s.getType());
    }
}