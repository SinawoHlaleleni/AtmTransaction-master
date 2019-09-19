package ATMtrans.service.cardlessService;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface CardlessWithdrawalService extends IService <CardlessWithdrawal,Double> {
    Set<CardlessWithdrawal> getAll();
}