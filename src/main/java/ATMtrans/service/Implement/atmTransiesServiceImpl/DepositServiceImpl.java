package ATMtrans.service.Implement.atmTransiesServiceImpl;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.repository.Implement.atmTransiesImpl.DepositRepositoryImpl;
import ATMtrans.repository.repositoryAtmTransies.DepositRepository;
import ATMtrans.service.atmTransiesService.DepositService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class DepositServiceImpl implements DepositService {

    public static DepositServiceImpl service = null;
    private DepositRepository repository;

    private DepositServiceImpl(){
        this.repository= DepositRepositoryImpl.getRepository();
    }
    public static DepositServiceImpl getService(){
        if(service == null) service = new DepositServiceImpl();
        return service;
    }

    @Override
    public Set<Deposit> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Deposit create(Deposit deposit) {
        return this.repository.create(deposit);
    }

    @Override
    public Deposit update(Deposit deposit) {
        return this.repository.update(deposit);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public Deposit read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
