package ATMtrans.repository.repositoryAtmInf;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface TopupRepository extends IRepository<Topup,Double> {
    Set<Topup> getAll();
}
