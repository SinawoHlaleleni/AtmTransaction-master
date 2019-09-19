package ATMtrans.service.Implement.bankServiceImpl;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.repository.Implement.bankInforImpl.BankRepositoryImpl;
import ATMtrans.repository.repositoryBankInfor.BankRepository;
import ATMtrans.service.bankInforService.BankService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class BankServiceImpl implements BankService {

    public static BankServiceImpl service = null;
    private BankRepository repository;

    private BankServiceImpl(){
        this.repository= BankRepositoryImpl.getRepository();
    }
    public static BankServiceImpl getService(){
        if(service == null) service = new BankServiceImpl();
        return service;
    }

    @Override
    public Set<Bank> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Bank create(Bank bank) {
        return this.repository.create(bank);
    }

    @Override
    public Bank update(Bank bank) {
        return this.repository.update(bank);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Bank read(String s) {
        return this.repository.read(s);
    }
}
