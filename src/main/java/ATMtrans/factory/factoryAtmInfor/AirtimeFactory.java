package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.util.Misc;

public class AirtimeFactory {

    public static Airtime getAmount(double tAmount) {
        return new Airtime.Builder()
                .tAmount(tAmount)
                .tType("MTN")
                .tId(Misc.generateId())
                .build();
    }
}
