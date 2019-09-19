package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.util.Misc;

public class ElectricityFactory {

    public static Electricity getAmount(double tAmount) {
        return new Electricity.Builder()
                .Amount(tAmount)
                .MeterNum("0135769543")
                .Id(Misc.generateId())
                .build();
    }
}
