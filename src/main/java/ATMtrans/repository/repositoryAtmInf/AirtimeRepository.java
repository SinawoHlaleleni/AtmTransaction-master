package ATMtrans.repository.repositoryAtmInf;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface AirtimeRepository extends IRepository<Airtime,Double> {
        Set<Airtime> getAll();
}

