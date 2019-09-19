package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Check;
import ATMtrans.util.Misc;

public class CheckFactory {

    public static Check getAmount(double amount) {
        return new Check.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }
}
