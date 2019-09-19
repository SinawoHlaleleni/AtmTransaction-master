package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.repository.repositoryAtmInf.AirtimeRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class AirtimeRepositoryImpl implements AirtimeRepository {

    public static AirtimeRepositoryImpl repository = null;
    private Set<Airtime> airtimes;

    private AirtimeRepositoryImpl() {
        airtimes = new HashSet<>();
    }

    private Airtime findAirtime(String Id){
        return this.airtimes.stream()
                .filter( airtime -> airtime.gettId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static AirtimeRepository getRepository(){
        if (repository == null) repository = new AirtimeRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Airtime> getAll() {
        return this.airtimes;
    }

    @Override
    public Airtime create(Airtime airtime) {
        this.airtimes.add( airtime );
        return airtime;
    }

    @Override
    public Airtime update(Airtime airtime) {
        Airtime toUpdate = findAirtime( airtime.gettId() );
        if(toUpdate != null){
            this.airtimes.remove( toUpdate );
            return create( airtime );
        }
        return null;

    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Airtime read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Airtime airtime = findAirtime( Id );
        if(airtime != null) this.airtimes.remove( airtime );
    }

    public Airtime read(String Id) {
        Airtime airtime = findAirtime( Id );
        return airtime;
    }
}
