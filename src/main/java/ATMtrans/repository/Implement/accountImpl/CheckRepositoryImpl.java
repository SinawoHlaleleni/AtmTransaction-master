package ATMtrans.repository.Implement.accountImpl;

import ATMtrans.domain.account.Check;
import ATMtrans.repository.repositoryAccount.CheckRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class CheckRepositoryImpl implements CheckRepository {

    public static CheckRepositoryImpl repository = null;
    private Set<Check> checks;

    private CheckRepositoryImpl() {
       this.checks = new HashSet<>();
    }

    private Check findCheck(String Id){
        return this.checks.stream()
                .filter( check -> check.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static CheckRepository getRepository(){
        if (repository == null) repository = new CheckRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Check> getAll() {
        return this.checks;
    }

    @Override
    public Check create(Check check) {
       this.checks.add( check );
        return check;
    }
    @Override
    public Check update(Check check) {
        Check toUpdate = findCheck( check.getId() );
        if(toUpdate != null){
            this.checks.remove( toUpdate );
            return create( check );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Check read(Double aDouble) {
        return null;
    }

    public void delete(String Id ) {
        Check check = findCheck( Id );
        if(check != null) this.checks.remove( check );
    }

    public Check read( final String Id) {
        Check check = findCheck( Id );
        return check;
    }
}
