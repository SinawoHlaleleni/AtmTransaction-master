package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.repository.Implement.atmInforImpl.CashLimitRepositoryImpl;
import ATMtrans.repository.repositoryAtmInf.CashLimitRepository;
import ATMtrans.service.atmInfService.CashLimitService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CashLimitServiceImpl implements CashLimitService {

    public static CashLimitServiceImpl service = null;
    private CashLimitRepository repository;

    private CashLimitServiceImpl(){
        this.repository= CashLimitRepositoryImpl.getRepository();
    }
    public static CashLimitServiceImpl getService(){
        if(service == null) service = new CashLimitServiceImpl();
        return service;
    }

    @Override
    public Set<CashLimit> getAll() {
        return this.repository.getAll();
    }

    @Override
    public CashLimit create(CashLimit cashLimit) {
        return this.repository.create(cashLimit);
    }

    @Override
    public CashLimit update(CashLimit cashLimit) {
        return this.repository.update(cashLimit);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public CashLimit read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
