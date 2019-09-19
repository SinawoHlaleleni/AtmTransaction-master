package ATMtrans.repository.repositoryAtmTransies;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface DepositRepository extends IRepository<Deposit,Double> {
    Set<Deposit> getAll();
}
