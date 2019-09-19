package ATMtrans.repository.repositoryAccount;

import ATMtrans.domain.account.Savings;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface SavingsRepository extends IRepository<Savings,Double> {
    Set<Savings> getAll();
}
