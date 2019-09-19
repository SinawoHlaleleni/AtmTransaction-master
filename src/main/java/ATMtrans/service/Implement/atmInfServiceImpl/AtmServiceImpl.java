package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.repository.Implement.atmInforImpl.AtmRepositoryImpl;
import ATMtrans.repository.repositoryAtmInf.AtmRepository;
import ATMtrans.service.atmInfService.AtmService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AtmServiceImpl implements AtmService {

    public static AtmServiceImpl service = null;
    private AtmRepository repository;

    private AtmServiceImpl(){
        this.repository= AtmRepositoryImpl.getRepository();
    }
    public static AtmServiceImpl getService(){
        if(service == null) service = new AtmServiceImpl();
        return service;
    }

    @Override
    public Set<Atm> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Atm create(Atm atm) {
        return this.repository.create(atm);
    }

    @Override
    public Atm update(Atm atm) {
        return this.repository.update(atm);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Atm read(String s) {
        return this.repository.read(s);
    }
}
