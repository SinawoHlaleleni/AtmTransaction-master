package ATMtrans.factory.factoryOrders;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.util.Misc;

public class CreditOrderFactory {

    public static CreditOrder getAmount(double amount) {
        return new CreditOrder.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }
}
