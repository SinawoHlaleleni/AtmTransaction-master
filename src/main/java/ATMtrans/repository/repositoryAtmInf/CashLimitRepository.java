package ATMtrans.repository.repositoryAtmInf;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface CashLimitRepository extends IRepository<CashLimit,Double> {
    Set<CashLimit> getAll();
}
