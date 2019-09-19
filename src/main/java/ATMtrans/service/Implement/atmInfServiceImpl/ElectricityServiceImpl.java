package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.repository.Implement.atmInforImpl.ElectricityRepositoryImpl;
import ATMtrans.repository.repositoryAtmInf.ElectricityRepository;
import ATMtrans.service.atmInfService.ElectricityService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ElectricityServiceImpl implements ElectricityService {

    public static ElectricityServiceImpl service = null;
    private ElectricityRepository repository;

    private ElectricityServiceImpl(){
        this.repository= ElectricityRepositoryImpl.getRepository();
    }

    public static ElectricityServiceImpl getService(){
        if(service == null) service = new ElectricityServiceImpl();
        return service;
    }

    @Override
    public Set<Electricity> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Electricity create(Electricity electricity) {
        return this.repository.create(electricity);
    }

    @Override
    public Electricity update(Electricity electricity) {
        return this.repository.update(electricity);
    }

    @Override
    public void delete(String s) {
    repository.delete(s);
    }

    @Override
    public Electricity read(String s) {
        return this.repository.read(s);
    }
}
