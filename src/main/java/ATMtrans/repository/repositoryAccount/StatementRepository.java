package ATMtrans.repository.repositoryAccount;

import ATMtrans.domain.account.Statement;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface StatementRepository extends IRepository<Statement,String> {
    Set<Statement> getAll();
}
