package ATMtrans.repository.Implement.atmTransiesImpl;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.repository.repositoryAtmTransies.BalanceRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

    public static BalanceRepositoryImpl repository = null;
    private Set<Balance> balances;

    private BalanceRepositoryImpl() {
        balances = new HashSet<>();
    }

    private Balance findBalance(String Id){
        return this.balances.stream()
                .filter( balance -> balance.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static BalanceRepository getRepository(){
        if (repository == null) repository = new BalanceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Balance> getAll() {
        return this.balances;
    }

    @Override
    public Balance create(Balance balance) {
        this.balances.add( balance );
        return balance;

    }

    @Override
    public Balance update(Balance balance) {
        Balance toUpdate = findBalance( balance.getId() );
        if(toUpdate != null){
            this.balances.remove( toUpdate );
            return create( balance );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Balance read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Balance balance = findBalance( Id );
        if(balance != null) this.balances.remove( balance );
    }

    public Balance read(String Id) {
        Balance balance = findBalance( Id );
        return balance;
    }
}
