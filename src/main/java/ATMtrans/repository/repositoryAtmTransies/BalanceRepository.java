package ATMtrans.repository.repositoryAtmTransies;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface BalanceRepository extends IRepository<Balance,Double> {
    Set<Balance> getAll();
}

