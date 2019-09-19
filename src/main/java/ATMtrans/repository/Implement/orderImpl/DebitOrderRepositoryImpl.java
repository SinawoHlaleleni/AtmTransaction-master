package ATMtrans.repository.Implement.orderImpl;

import ATMtrans.domain.orders.DebitOrders;
import ATMtrans.repository.repositoryOrder.DebitOrderRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository
public class DebitOrderRepositoryImpl implements DebitOrderRepository {

    public static DebitOrderRepositoryImpl repository = null;
    private Map<Double, DebitOrders> DebitOrderTable;

    private DebitOrderRepositoryImpl() {
        DebitOrderTable = new HashMap<>();
    }

    public static DebitOrderRepository getRepository(){
        if (repository == null) repository = new DebitOrderRepositoryImpl();
        return repository;
    }
    @Override
    public Set<DebitOrders> getAll() {
        return this.getAll();
    }

    @Override
    public DebitOrders create(DebitOrders debitOrders) {

        DebitOrderTable.put(debitOrders.getAmount(),debitOrders);
        DebitOrders creditOrder1 = DebitOrderTable.get(debitOrders.getAmount());
        return creditOrder1;
    }

    @Override
    public DebitOrders update(DebitOrders debitOrders) {
        DebitOrderTable.put(debitOrders.getAmount(),debitOrders);
        DebitOrders creditOrder1 = DebitOrderTable.get(debitOrders.getAmount());
        return creditOrder1;
    }

    @Override
    public void delete(Double aDouble) {
        DebitOrderTable.remove(aDouble);
        //return this.delete(aDouble);
    }

    @Override
    public DebitOrders read(Double aDouble) {
        DebitOrders debitOrders = DebitOrderTable.get(aDouble);
        return debitOrders;
    }
}
