package ATMtrans.repository.Implement.atmTransiesImpl;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.repository.repositoryAtmTransies.WithdrawalRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class WithdrawalRepositoryImpl implements WithdrawalRepository {

    public static WithdrawalRepositoryImpl repository = null;
    private Set<Withdrawal> withdrawals;

    private WithdrawalRepositoryImpl() {
        withdrawals = new HashSet<>();
    }

    private Withdrawal findWithdrawal(String Id){
        return this.withdrawals.stream()
                .filter( withdrawal -> withdrawal.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static WithdrawalRepository getRepository(){
        if (repository == null) repository = new WithdrawalRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Withdrawal> getAll() {
        return this.withdrawals;
    }

    @Override
    public Withdrawal create(Withdrawal withdrawal) {
        this.withdrawals.add( withdrawal );
        return withdrawal;
    }
    @Override
    public Withdrawal update(Withdrawal withdrawal) {

        Withdrawal toUpdate = findWithdrawal( withdrawal.getId() );
        if(toUpdate != null){
            this.withdrawals.remove( toUpdate );
            return create(withdrawal );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public Withdrawal read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Withdrawal withdrawal = findWithdrawal( Id );
        if(withdrawal != null) this.withdrawals.remove( withdrawal );
    }

    public Withdrawal read(String Id) {
        Withdrawal withdrawal = findWithdrawal( Id );
        return withdrawal;
    }
}
