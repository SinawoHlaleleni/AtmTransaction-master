package ATMtrans.repository.repositoryAccount;

import ATMtrans.domain.account.Account;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface AccountRepository extends IRepository<Account,Double> {
    Set<Account> getAll();

}

