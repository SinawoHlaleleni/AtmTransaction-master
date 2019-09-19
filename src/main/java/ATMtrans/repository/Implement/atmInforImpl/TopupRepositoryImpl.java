package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.repository.repositoryAtmInf.TopupRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class TopupRepositoryImpl implements TopupRepository {

    public static TopupRepositoryImpl repository = null;
    private Set<Topup> topups;

    private TopupRepositoryImpl() {
        topups = new HashSet<>();
    }

    private Topup findTopup(String Id){
        return this.topups.stream()
                .filter( topup -> topup.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static TopupRepository getRepository(){
        if (repository == null) repository = new TopupRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Topup> getAll() {
        return this.topups;
    }

    @Override
    public Topup create(Topup topup) {
        this.topups.add( topup );
        return topup;

    }

    @Override
    public Topup update(Topup topup) {
        Topup toUpdate = findTopup( topup.getId() );
        if(toUpdate != null){
            this.topups.remove( toUpdate );
            return create( topup );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Topup read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Topup topup = findTopup( Id );
        if(topup != null) this.topups.remove( topup );
    }

    public Topup read(String Id) {
        Topup topup = findTopup( Id );
        return topup;
    }
}
