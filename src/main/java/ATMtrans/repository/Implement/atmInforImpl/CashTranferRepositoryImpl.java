package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.repository.repositoryAtmInf.CashTranferRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class CashTranferRepositoryImpl implements CashTranferRepository {
    public static CashTranferRepositoryImpl repository = null;
    private Set<CashTransfer> cashTransfers;

    private CashTranferRepositoryImpl() {
        cashTransfers = new HashSet<>();
    }

    private CashTransfer findCashTransfer(String Id){
        return this.cashTransfers.stream()
                .filter( cashTransfer -> cashTransfer.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static CashTranferRepository getRepository(){
        if (repository == null) repository = new CashTranferRepositoryImpl();
        return repository;
    }

    @Override
    public Set<CashTransfer> getAll() {
        return this.cashTransfers;
    }
    @Override
    public CashTransfer create(CashTransfer cashTransfer) {
        this.cashTransfers.add( cashTransfer );
        return cashTransfer;
    }

    @Override
    public CashTransfer update(CashTransfer cashTransfer) {

        CashTransfer toUpdate = findCashTransfer( cashTransfer.getId() );
        if(toUpdate != null){
            this.cashTransfers.remove( toUpdate );
            return create( cashTransfer );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public CashTransfer read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        CashTransfer cashTransfer = findCashTransfer( Id );
        if(cashTransfer != null) this.cashTransfers.remove( cashTransfer );
    }

    public CashTransfer read(String Id ) {
        CashTransfer cashTransfer = findCashTransfer( Id );
        return cashTransfer;
    }
}
