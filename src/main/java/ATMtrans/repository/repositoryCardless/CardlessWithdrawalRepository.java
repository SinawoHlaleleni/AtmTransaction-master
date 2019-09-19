package ATMtrans.repository.repositoryCardless;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface CardlessWithdrawalRepository extends IRepository<CardlessWithdrawal,Double> {
    Set<CardlessWithdrawal> getAll();
}

