package ATMtrans.repository.Implement.accountImpl;

import ATMtrans.domain.account.Savings;
import ATMtrans.repository.repositoryAccount.SavingsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class SavingRepositoryImpl implements SavingsRepository {

    public static SavingRepositoryImpl repository = null;
    private Set<Savings> savin;

    private SavingRepositoryImpl() {
        savin = new HashSet<>();
    }

    private Savings findSavings(String Id){
        return this.savin.stream()
                .filter( savings -> savings.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static SavingRepositoryImpl getRepository(){
        if (repository == null) repository = new SavingRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Savings> getAll() {
        return this.savin;
    }

    @Override
    public Savings create(Savings savings) {
        this.savin.add( savings );
        return savings;
    }

    @Override
    public Savings update(Savings savings) {
        Savings toUpdate = findSavings( savings.getId() );
        if(toUpdate != null){
            this.savin.remove( toUpdate );
            return create( savings );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Savings read(Double aDouble) {
        return null;
    }


    public void delete(String Id) {
        Savings savings = findSavings( Id );
        if(savings != null) this.savin.remove( savings );
    }


    public Savings read(String Id) {
        Savings savings = findSavings( Id );
        return savings;
    }
}
