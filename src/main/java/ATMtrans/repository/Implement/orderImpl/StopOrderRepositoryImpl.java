package ATMtrans.repository.Implement.orderImpl;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.repository.repositoryOrder.StopOrderRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository
public class StopOrderRepositoryImpl implements StopOrderRepository {
    public static StopOrderRepositoryImpl repository = null;
    private Set< StopOrder > stopOrders;

    private StopOrderRepositoryImpl() {
        stopOrders = new HashSet<>();
    }

    private StopOrder findStopOrder(String Id) {
        return this.stopOrders.stream()
                .filter( stopOrder -> stopOrder.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static StopOrderRepository getRepository() {
        if (repository == null) repository = new StopOrderRepositoryImpl();
        return repository;
    }

    @Override
    public Set< StopOrder > getAll() {
        return this.stopOrders;
    }

    @Override
    public StopOrder create(StopOrder stopOrder) {
        this.stopOrders.add( stopOrder );
        return stopOrder;
    }
    public StopOrder update(StopOrder stopOrder)
    {
        StopOrder toUpdate = findStopOrder( stopOrder.getId() );
        if(toUpdate != null){
            this.stopOrders.remove( toUpdate );
            return create(stopOrder );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public StopOrder read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        StopOrder stopOrder = findStopOrder( Id );
        if(stopOrder != null) this.stopOrders.remove( stopOrder );
    }

    public StopOrder read(String Id) {
        StopOrder stopOrder = findStopOrder( Id );
        return stopOrder;
    }

}