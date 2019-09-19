package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.repository.Implement.atmInforImpl.TopupRepositoryImpl;
import ATMtrans.repository.repositoryAtmInf.TopupRepository;
import ATMtrans.service.atmInfService.TopupService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class TopupServiceImpl implements TopupService {

    public static TopupServiceImpl service = null;
    private TopupRepository repository;

    private TopupServiceImpl(){
        this.repository= TopupRepositoryImpl.getRepository();
    }
    public static TopupServiceImpl getService(){
        if(service == null) service = new TopupServiceImpl();
        return service;
    }

    @Override
    public Set<Topup> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Topup create(Topup topup) {
        return this.repository.create(topup);
    }

    @Override
    public Topup update(Topup topup) {
        return this.repository.update(topup);
    }

    @Override
    public void delete(Double aDouble) {
    repository.delete(aDouble);
    }

    @Override
    public Topup read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
