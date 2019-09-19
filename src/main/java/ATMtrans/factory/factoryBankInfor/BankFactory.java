package ATMtrans.factory.factoryBankInfor;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.util.Misc;

public class BankFactory {

    public static Bank getName(String Name) {
        return new Bank.Builder()
                .Name("ABSA")
                .Id(Misc.generateId())
                .build();
    }
}
