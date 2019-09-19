package ATMtrans.repository.Implement.accountImpl;

import ATMtrans.domain.account.Flexible;
import ATMtrans.repository.repositoryAccount.FlexibleRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class FlexibleRepositoryImpl implements FlexibleRepository {

    public static FlexibleRepositoryImpl repository = null;
    private Set<Flexible> flexibles;

    private FlexibleRepositoryImpl() {
        flexibles = new HashSet<>();
    }

    private Flexible findFlexible(String Id){
        return this.flexibles.stream()
                .filter( flexible -> flexible.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static FlexibleRepository getRepository(){
        if (repository == null) repository = new FlexibleRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Flexible> getAll() {
        return this.flexibles;
    }

    @Override
    public Flexible create(Flexible flexible) {
        this.flexibles.add( flexible );
        return flexible;

    }

    @Override
    public Flexible update(Flexible flexible) {
        Flexible toUpdate = findFlexible( flexible.getId() );
        if(toUpdate != null){
            this.flexibles.remove( toUpdate );
            return create( flexible );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Flexible read(Double aDouble) {
        return null;
    }


    public void delete(String Id) {
        Flexible flexible = findFlexible( Id );
        if(flexible != null) this.flexibles.remove( flexible );
    }


    public Flexible read(String Id) {
        Flexible flexible = findFlexible( Id );
        return flexible;
    }
}
