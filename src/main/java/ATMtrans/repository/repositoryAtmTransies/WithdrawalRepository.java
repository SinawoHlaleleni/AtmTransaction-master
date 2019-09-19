package ATMtrans.repository.repositoryAtmTransies;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface WithdrawalRepository  extends IRepository<Withdrawal,Double> {
    Set<Withdrawal> getAll();
}

