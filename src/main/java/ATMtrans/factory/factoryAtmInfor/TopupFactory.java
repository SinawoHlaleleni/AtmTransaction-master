package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.util.Misc;

public class TopupFactory {

    public static Topup getType(String Type) {
        return new Topup.Builder()
                .Type("SMS")
                .Id(Misc.generateId())
                .build();
    }

}
