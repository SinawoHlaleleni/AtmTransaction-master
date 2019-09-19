package ATMtrans.repository.repositoryAccount;

import ATMtrans.domain.account.Check;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface CheckRepository extends IRepository<Check,Double> {
    Set<Check>getAll();
}
