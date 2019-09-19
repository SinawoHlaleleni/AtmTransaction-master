package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.util.Misc;

public class CashLimitFactory {

    public static CashLimit getAmount(double Amount) {
        return new CashLimit.Builder()
                .Amount(Amount)
                .Id(Misc.generateId())
                .build();
    }
}
