package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.util.Misc;

public class AtmFactory {

    public static Atm getType(String Type) {
        return new Atm.Builder()
                .Type("ABSA")
                .Id(Misc.generateId())
                .build();
    }
}
