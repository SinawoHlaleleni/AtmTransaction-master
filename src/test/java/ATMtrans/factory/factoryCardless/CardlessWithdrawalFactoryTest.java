package ATMtrans.factory.factoryCardless;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import org.junit.Assert;
import org.junit.Test;

public class CardlessWithdrawalFactoryTest {

    @Test
    public void getAmount() {

        CardlessWithdrawal s = CardlessWithdrawalFactory.getAmount(350.00);
        System.out.println(s);
        Assert.assertNotNull(s.getAmount());
    }
}