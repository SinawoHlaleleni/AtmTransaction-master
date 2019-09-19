package ATMtrans.repository.Implement.accountImpl;

import ATMtrans.domain.account.Account;
import ATMtrans.repository.repositoryAccount.AccountRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    public static AccountRepositoryImpl repository = null;
    private Map<Double, Account> accountTable;

    private AccountRepositoryImpl() {
        accountTable = new HashMap<>();
    }

    public static AccountRepository getRepository(){
        if (repository == null) repository = new AccountRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Account> getAll() {
        return this.getAll();
    }

    @Override
    public Account create(Account account) {
        accountTable.put(account.getAmount(),account);
        Account account1 = accountTable.get(account.getAmount());
        return account1;
    }

    @Override
    public Account update(Account account) {
        accountTable.put(account.getAmount(),account);
        Account account1 = accountTable.get(account.getAmount());
        return account1;
    }

    @Override
    public void delete(Double aDouble) {
        accountTable.remove(aDouble);
        //return this.delete(aDouble);
    }

    @Override
    public Account read(Double aDouble) {
        Account account = accountTable.get(aDouble);
        return account;
    }
}
