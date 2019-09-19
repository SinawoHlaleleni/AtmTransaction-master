package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.repository.repositoryAtmInf.AtmRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class AtmRepositoryImpl implements AtmRepository {

    public static AtmRepositoryImpl repository = null;
    private Set<Atm> atms;

    private AtmRepositoryImpl() {
        atms = new HashSet<>();
    }

    private Atm findAtm(String Id){
        return this.atms.stream()
                .filter( atm -> atm.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }


    public static AtmRepository getRepository(){
        if (repository == null) repository = new AtmRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Atm> getAll() {
        return this.atms;
    }

    @Override
    public Atm create(Atm atm) {
        this.atms.add( atm );
        return atm;
    }

    @Override
    public Atm update(Atm atm) {
        Atm toUpdate = findAtm( atm.getId() );
        if(toUpdate != null){
            this.atms.remove( toUpdate );
            return create( atm );
        }
        return null;
    }

    @Override
    public void delete(String Id) {
        Atm atm = findAtm( Id );
        if(atm != null) this.atms.remove( atm );
    }

    @Override
    public Atm read(String Id) {
        Atm atm = findAtm( Id );
        return atm;
    }
}
