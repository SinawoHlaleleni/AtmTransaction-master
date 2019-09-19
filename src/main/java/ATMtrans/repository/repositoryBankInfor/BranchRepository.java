package ATMtrans.repository.repositoryBankInfor;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface BranchRepository extends IRepository<Branch,String> {
    Set<Branch> getAll();
}

