package ATMtrans.repository.Implement.orderImpl;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.repository.repositoryOrder.CreditOrderRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class CreditOrderRepositoryImpl implements CreditOrderRepository {

    public static CreditOrderRepositoryImpl repository = null;
    private Set<CreditOrder> creditOrders;

    private CreditOrderRepositoryImpl() {
        creditOrders = new HashSet<>();
    }

    private CreditOrder findCreditOrder(String Id){
        return this.creditOrders.stream()
                .filter( creditOrder -> creditOrder.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static CreditOrderRepository getRepository(){
        if (repository == null) repository = new CreditOrderRepositoryImpl();
        return repository;
    }

    @Override
    public Set<CreditOrder> getAll() {
        return this.creditOrders;
    }

    @Override
    public CreditOrder create(CreditOrder creditOrder) {
        this.creditOrders.add( creditOrder );
        return creditOrder;

    }

    @Override
    public CreditOrder update(CreditOrder creditOrder) {
        CreditOrder toUpdate = findCreditOrder( creditOrder.getId() );
        if(toUpdate != null){
            this.creditOrders.remove( toUpdate );
            return create(creditOrder );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public CreditOrder read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        CreditOrder creditOrder = findCreditOrder( Id );
        if(creditOrder != null) this.creditOrders.remove( creditOrder );
    }

    public CreditOrder read(String Id) {
        CreditOrder creditOrder = findCreditOrder( Id );
        return creditOrder;
    }
}
