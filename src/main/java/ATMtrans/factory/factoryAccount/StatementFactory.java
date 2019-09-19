package ATMtrans.factory.factoryAccount;

import ATMtrans.domain.account.Statement;
import ATMtrans.util.Misc;

public class StatementFactory {

    public static Statement getType(String Type){

        return new Statement.Builder()
                .id(Misc.generateId())
                .type("3 Months")
                .build();
    }
}
