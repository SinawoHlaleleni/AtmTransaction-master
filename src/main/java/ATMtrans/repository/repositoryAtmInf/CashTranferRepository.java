package ATMtrans.repository.repositoryAtmInf;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface CashTranferRepository extends IRepository<CashTransfer,Double> {
    Set<CashTransfer> getAll();
}
