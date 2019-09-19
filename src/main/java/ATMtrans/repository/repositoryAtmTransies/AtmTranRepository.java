package ATMtrans.repository.repositoryAtmTransies;

import ATMtrans.domain.atmTransies.AtmTran;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface AtmTranRepository extends IRepository<AtmTran,Double> {
    Set<AtmTran> getAll();
}

