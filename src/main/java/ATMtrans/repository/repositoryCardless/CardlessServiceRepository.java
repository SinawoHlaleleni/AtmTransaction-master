package ATMtrans.repository.repositoryCardless;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface CardlessServiceRepository extends IRepository<CardlessService,Double> {
    Set<CardlessService> getAll();
}

