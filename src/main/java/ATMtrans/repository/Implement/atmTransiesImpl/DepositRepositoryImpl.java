package ATMtrans.repository.Implement.atmTransiesImpl;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.repository.repositoryAtmTransies.DepositRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class DepositRepositoryImpl implements DepositRepository {
    public static DepositRepositoryImpl repository = null;
    private Set<Deposit> deposits;

    private DepositRepositoryImpl() {
        deposits= new HashSet<>();
    }

    private Deposit findDeposit(String Id){
        return this.deposits.stream()
                .filter( deposit -> deposit.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static DepositRepository getRepository(){
        if (repository == null) repository = new DepositRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Deposit> getAll() {
        return this.deposits;
    }

    @Override
    public Deposit create(Deposit deposit) {
        this.deposits.add(deposit );
        return deposit;
    }
    @Override
    public Deposit update(Deposit deposit) {
        Deposit toUpdate = findDeposit( deposit.getId() );
        if(toUpdate != null){
            this.deposits.remove( toUpdate );
            return create( deposit );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Deposit read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Deposit deposit = findDeposit( Id );
        if(deposit != null) this.deposits.remove( deposit );
    }

    public Deposit read(String Id) {
        Deposit deposit = findDeposit( Id );
        return deposit;
    }
}
