package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.repository.repositoryAtmInf.ElectricityRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class ElectricityRepositoryImpl implements ElectricityRepository {
    public static ElectricityRepositoryImpl repository = null;
    private Set<Electricity> electricitys;

    private ElectricityRepositoryImpl() {
        electricitys = new HashSet<>();
    }

    private Electricity findElectricity(String Id){
        return this.electricitys.stream()
                .filter( electricity -> electricity.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static ElectricityRepository getRepository() {
        if (repository == null) repository = new ElectricityRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Electricity> getAll() {
        return this.electricitys;
    }

    @Override
    public Electricity create(Electricity electricity) {
        this.electricitys.add( electricity );
        return electricity;

    }

    @Override
    public Electricity update(Electricity electricity) {

        Electricity toUpdate = findElectricity( electricity.getId() );
        if(toUpdate != null){
            this.electricitys.remove( toUpdate );
            return create(electricity );
        }
        return null;
    }
    @Override
    public void delete(String Id) {
        Electricity electricity = findElectricity( Id );
        if(electricity != null) this.electricitys.remove( electricity );
    }

    @Override
    public Electricity read(String Id) {
        Electricity electricity = findElectricity( Id );
        return electricity;
    }
}
