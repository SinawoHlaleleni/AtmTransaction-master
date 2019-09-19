package ATMtrans.factory.factoryAtmTransies;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.util.Misc;

public class DepositFactory {

    public static Deposit getAmount(double amount) {
        return new Deposit.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }
}
