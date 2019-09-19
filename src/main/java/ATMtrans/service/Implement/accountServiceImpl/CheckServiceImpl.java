package ATMtrans.service.Implement.accountServiceImpl;

import ATMtrans.domain.account.Check;
import ATMtrans.repository.Implement.accountImpl.CheckRepositoryImpl;
import ATMtrans.repository.repositoryAccount.CheckRepository;
import ATMtrans.service.accountService.CheckService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CheckServiceImpl implements CheckService {

    public static CheckServiceImpl service = null;
    private CheckRepository repository;

    private CheckServiceImpl(){
        this.repository=CheckRepositoryImpl.getRepository();
    }
    public static CheckServiceImpl getService(){
        if(service == null) service = new CheckServiceImpl();
        return service;
    }

    @Override
    public Set<Check> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Check create(Check check) {
        return this.repository.create(check);
    }

    @Override
    public Check update(Check check) {
        return this.repository.update(check);
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Check read(String s) {
        return null;
    }

    public void delete(Double amount) {
        repository.delete(amount);
    }

    public Check read(Double amount) {
        return this.repository.read(amount);
    }
}
