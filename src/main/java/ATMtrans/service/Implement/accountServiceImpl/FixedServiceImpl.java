package ATMtrans.service.Implement.accountServiceImpl;

import ATMtrans.domain.account.Fixed;
import ATMtrans.repository.Implement.accountImpl.FixedRepositoryImpl;
import ATMtrans.repository.repositoryAccount.FixedRepository;
import ATMtrans.service.accountService.FixedService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class FixedServiceImpl implements FixedService {
    public static FixedServiceImpl service = null;
    private FixedRepository repository;

    private FixedServiceImpl(){
        this.repository= FixedRepositoryImpl.getRepository();
    }

    public static FixedServiceImpl getService(){
        if(service == null) service = new FixedServiceImpl();
        return service;
    }

    @Override
    public Set<Fixed> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Fixed create(Fixed fixed) {
        return this.repository.create(fixed);
    }

    @Override
    public Fixed update(Fixed fixed) {
        return this.repository.update(fixed);
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Fixed read(String s) {
        return null;
    }

    public void delete(Double amount) {
        repository.delete(amount);
    }

    public Fixed read(Double amount) {
        return this.repository.read(amount);
    }
}
