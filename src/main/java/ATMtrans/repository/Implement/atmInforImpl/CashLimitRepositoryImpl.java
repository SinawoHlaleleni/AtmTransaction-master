package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.repository.repositoryAtmInf.CashLimitRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class CashLimitRepositoryImpl implements CashLimitRepository {

    public static CashLimitRepositoryImpl repository = null;
    private Set<CashLimit> cashLimitc;

    private CashLimitRepositoryImpl() {
        cashLimitc = new HashSet<>();
    }

    private CashLimit findCashLimit(String Id){
        return this.cashLimitc.stream()
                .filter( cashLimit -> cashLimit.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static CashLimitRepository getRepository(){
        if (repository == null) repository = new CashLimitRepositoryImpl();
        return repository;
    }


    @Override
    public CashLimit create(CashLimit cashLimit) {
        this.cashLimitc.add( cashLimit );
        return cashLimit;
    }

    @Override
    public CashLimit update(CashLimit cashLimit) {
        CashLimit toUpdate = findCashLimit( cashLimit.getId() );
        if(toUpdate != null){
            this.cashLimitc.remove( toUpdate );
            return create( cashLimit );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public CashLimit read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        CashLimit cashLimit = findCashLimit( Id );
        if(cashLimit != null) this.cashLimitc.remove( cashLimit );
    }

    public CashLimit read(String Id) {
        CashLimit cashLimit = findCashLimit( Id );
        return cashLimit;
    }

    @Override
    public Set<CashLimit> getAll()
    {
        return this.cashLimitc;
    }
}
