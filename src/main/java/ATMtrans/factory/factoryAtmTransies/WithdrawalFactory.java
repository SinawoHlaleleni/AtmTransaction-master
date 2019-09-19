package ATMtrans.factory.factoryAtmTransies;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.util.Misc;

public class WithdrawalFactory {

    public static Withdrawal getAmount(double amount) {
        return new Withdrawal.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }
}
