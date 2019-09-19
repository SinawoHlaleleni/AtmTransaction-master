package ATMtrans.repository.Implement.cardlessImpl;

import ATMtrans.domain.cardless.Ewallet;
import ATMtrans.repository.repositoryCardless.EwalletRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class EwalletRepositoryImpl implements EwalletRepository {

    public static EwalletRepositoryImpl repository = null;
    private Set<Ewallet> ewallets;

    private EwalletRepositoryImpl() {
        ewallets = new HashSet<>();
    }

    private Ewallet findEwallet(String Id){
        return this.ewallets.stream()
                .filter( ewallet -> ewallet.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static EwalletRepository getRepository(){
        if (repository == null) repository = new EwalletRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Ewallet> getAll() {
        return this.ewallets;
    }

    @Override
    public Ewallet create(Ewallet ewallet) {
        this.ewallets.add( ewallet );
        return ewallet;
    }

    @Override
    public Ewallet update(Ewallet ewallet) {
        Ewallet toUpdate = findEwallet( ewallet.getId() );
        if(toUpdate != null){
            this.ewallets.remove( toUpdate );
            return create(ewallet );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Ewallet read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Ewallet ewallet = findEwallet( Id );
        if(ewallet != null) this.ewallets.remove( ewallet );
    }

    public Ewallet read(String Id) {
        Ewallet ewallet = findEwallet( Id );
        return ewallet;
    }
}
