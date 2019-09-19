package ATMtrans.service.Implement.atmTransiesServiceImpl;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.repository.Implement.atmTransiesImpl.BalanceRepositoryImpl;
import ATMtrans.repository.repositoryAtmTransies.BalanceRepository;
import ATMtrans.service.atmTransiesService.BalanceService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class BalanceServiceImpl implements BalanceService {

    public static BalanceServiceImpl service = null;
    private BalanceRepository repository;

    private BalanceServiceImpl(){
        this.repository= BalanceRepositoryImpl.getRepository();
    }
    public static BalanceServiceImpl getService(){
        if(service == null) service = new BalanceServiceImpl();
        return service;
    }

    @Override
    public Set<Balance> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Balance create(Balance balance) {
        return this.repository.create(balance);
    }

    @Override
    public Balance update(Balance balance) {
        return this.repository.update(balance);
    }

    @Override
    public void delete(Double aDouble) {
    repository.delete(aDouble);
    }

    @Override
    public Balance read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
