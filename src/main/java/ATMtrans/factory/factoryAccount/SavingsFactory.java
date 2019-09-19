package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Savings;
import ATMtrans.util.Misc;

public class SavingsFactory {
    public static Savings getAmount(double amount) {
        return new Savings .Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }

}
