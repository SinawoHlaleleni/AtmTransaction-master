package ATMtrans.factory.factoryOrders;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.util.Misc;

public class StopOrderFactory {

    public static StopOrder getAmount(double amount) {
        return new StopOrder.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }
}
