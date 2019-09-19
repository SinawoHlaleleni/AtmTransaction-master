package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Fixed;
import ATMtrans.util.Misc;

public class FixedFactory {
    public static Fixed getAmount(double amount) {
        return new Fixed.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }

}
