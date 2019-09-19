package ATMtrans.repository.repositoryAtmInf;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface AtmRepository extends IRepository<Atm,String> {
    Set<Atm> getAll();
}

