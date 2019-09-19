package ATMtrans.factory.factoryBankInfor;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.util.Misc;

public class BranchFactory {

    public static Branch getName(String Name) {
        return new Branch.Builder()
                .Name("CNR ABSA branch")
                .Id(Misc.generateId())
                .build();
    }
}
