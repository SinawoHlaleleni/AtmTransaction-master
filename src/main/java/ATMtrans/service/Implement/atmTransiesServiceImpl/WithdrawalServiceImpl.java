package ATMtrans.service.Implement.atmTransiesServiceImpl;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.repository.Implement.atmTransiesImpl.WithdrawalRepositoryImpl;
import ATMtrans.repository.repositoryAtmTransies.WithdrawalRepository;
import ATMtrans.service.atmTransiesService.WithdrawalService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class WithdrawalServiceImpl implements WithdrawalService {

    public static WithdrawalServiceImpl service = null;
    private WithdrawalRepository repository;

    private WithdrawalServiceImpl(){
        this.repository= WithdrawalRepositoryImpl.getRepository();
    }
    public static WithdrawalServiceImpl getService(){
        if(service == null) service = new WithdrawalServiceImpl();
        return service;
    }

    @Override
    public Set<Withdrawal> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Withdrawal create(Withdrawal withdrawal) {
        return this.repository.create(withdrawal);
    }

    @Override
    public Withdrawal update(Withdrawal withdrawal) {
        return this.repository.update(withdrawal);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public Withdrawal read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
