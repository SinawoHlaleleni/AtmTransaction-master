package ATMtrans.repository.repositoryAccount;

import ATMtrans.domain.account.Flexible;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface FlexibleRepository extends IRepository<Flexible,Double> {
    Set<Flexible> getAll();
}
