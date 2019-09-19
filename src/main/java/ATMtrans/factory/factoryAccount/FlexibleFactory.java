package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Flexible;
import ATMtrans.util.Misc;

public class FlexibleFactory {

    public static Flexible getAmount(double amount) {
        return new Flexible.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }
}
