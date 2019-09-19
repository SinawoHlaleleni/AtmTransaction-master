package ATMtrans.factory.factoryCardless;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.util.Misc;

public class CardlessServiceFactory {

    public static CardlessService getType(String Type) {
        return new CardlessService.Builder()
                .Type("0052")
                .Id(Misc.generateId())
                .build();
    }
}
