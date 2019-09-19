package ATMtrans.repository.repositoryAccount;

import ATMtrans.domain.account.Fixed;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface FixedRepository extends IRepository<Fixed,Double> {
    Set<Fixed> getAll();
}
