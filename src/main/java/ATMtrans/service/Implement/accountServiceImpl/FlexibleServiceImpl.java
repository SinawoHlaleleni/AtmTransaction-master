package ATMtrans.service.Implement.accountServiceImpl;

import ATMtrans.domain.account.Flexible;
import ATMtrans.repository.Implement.accountImpl.FlexibleRepositoryImpl;
import ATMtrans.repository.repositoryAccount.FlexibleRepository;
import ATMtrans.service.accountService.FlexibleService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class FlexibleServiceImpl implements FlexibleService {

    public static FlexibleServiceImpl service = null;

    private FlexibleRepository repository;
    private FlexibleServiceImpl(){
        this.repository= FlexibleRepositoryImpl.getRepository();
    }

    public static FlexibleServiceImpl getService(){
        if(service == null) service = new FlexibleServiceImpl();
        return service;
    }

    @Override
    public Set<Flexible> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Flexible create(Flexible flexible) {
        return this.repository.create(flexible);
    }

    @Override
    public Flexible update(Flexible flexible) {
        return this.repository.update(flexible);
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Flexible read(String s) {
        return null;
    }

    public void delete(Double amount) {
    repository.delete(amount);
    }

    public Flexible read(Double amount) {
        return this.repository.read(amount);
    }
}
