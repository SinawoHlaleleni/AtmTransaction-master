package ATMtrans.factory.factoryAtmTransies;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.util.Misc;

public class BalanceFactory {

    public static Balance getAmount(double amount) {
        return new Balance.Builder()
                .amount(amount)
               .Id( Misc.generateId())
                .build();
    }



}





