package ATMtrans.repository.repositoryCardless;

import ATMtrans.domain.cardless.Ewallet;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface EwalletRepository extends IRepository<Ewallet,Double> {
    Set<Ewallet> getAll();
}

