package ATMtrans.factory.factoryCardless;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.util.Misc;

public class CardlessWithdrawalFactory {

    public static CardlessWithdrawal getAmount(double amount) {
        return new CardlessWithdrawal.Builder()
                .amount(amount)
                .Id( Misc.generateId())
                .build();
    }


}
