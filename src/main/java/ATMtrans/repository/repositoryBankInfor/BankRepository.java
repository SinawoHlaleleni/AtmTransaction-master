package ATMtrans.repository.repositoryBankInfor;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface BankRepository extends IRepository<Bank,String> {
    Set<Bank> getAll();
}

