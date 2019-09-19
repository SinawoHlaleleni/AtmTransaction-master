package ATMtrans.repository.Implement.accountImpl;

import ATMtrans.domain.account.Account;
import ATMtrans.domain.account.Fixed;
import ATMtrans.repository.repositoryAccount.FixedRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class FixedRepositoryImpl implements FixedRepository {

    public static FixedRepositoryImpl repository = null;
    private Set<Fixed> fixeds;

    private FixedRepositoryImpl() {
        fixeds = new HashSet<>();
    }

    private Fixed findFixed (String Id){
        return this.fixeds.stream()
                .filter( fixed -> fixed.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static FixedRepository getRepository(){
        if (repository == null) repository = new FixedRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Fixed> getAll() {
        return this.fixeds;
    }
    @Override
    public Fixed create(Fixed fixed) {
        this.fixeds.add( fixed );
        return fixed;
    }
    @Override
    public Fixed update(Fixed fixed) {
        Fixed toUpdate = findFixed( fixed.getId() );
        if(toUpdate != null){
            this.fixeds.remove( toUpdate );
            return create( fixed );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Fixed read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Fixed fixed = findFixed( Id );
        if(fixed != null) this.fixeds.remove( fixed );
    }

    public Fixed read(String Id) {
        Fixed fixed = findFixed( Id );
        return fixed;
    }
}
