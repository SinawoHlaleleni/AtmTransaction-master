package ATMtrans.factory.factoryAtmInfor;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.util.Misc;

public class CashTransferFactory {

    public static CashTransfer getAmount(double tAmount) {
        return new CashTransfer.Builder()
                .Amount(tAmount)
                .num("0736072671")
                .Id(Misc.generateId())
                .build();
    }

}
