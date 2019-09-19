package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.repository.Implement.atmInforImpl.AirtimeRepositoryImpl;
import ATMtrans.repository.repositoryAtmInf.AirtimeRepository;
import ATMtrans.service.atmInfService.AirtimeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AirtimeServiceImpl implements AirtimeService {

    public static AirtimeServiceImpl service = null;
    private AirtimeRepository repository;

    private AirtimeServiceImpl(){
        this.repository= AirtimeRepositoryImpl.getRepository();
    }
    public static AirtimeServiceImpl getService(){
        if(service == null) service = new AirtimeServiceImpl();
        return service;
    }

    @Override
    public Set<Airtime> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Airtime create(Airtime airtime) {
        return this.repository.create(airtime);
    }

    @Override
    public Airtime update(Airtime airtime) {
        return this.repository.update(airtime);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public Airtime read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
