package ATMtrans.service.Implement.orderServiceImpl;

import ATMtrans.domain.orders.DebitOrders;
import ATMtrans.repository.Implement.orderImpl.DebitOrderRepositoryImpl;
import ATMtrans.repository.repositoryOrder.DebitOrderRepository;
import ATMtrans.service.orderService.DebitOrderService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class DebitOrderServiceImpl implements DebitOrderService {

    public static DebitOrderServiceImpl service = null;
    private DebitOrderRepository repository;

    private DebitOrderServiceImpl(){
        this.repository= DebitOrderRepositoryImpl.getRepository();
    }
    public static DebitOrderServiceImpl getService(){
        if(service == null) service = new DebitOrderServiceImpl();
        return service;
    }

    @Override
    public Set<DebitOrders> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DebitOrders create(DebitOrders debitOrders) {
        return this.repository.create(debitOrders);
    }

    @Override
    public DebitOrders update(DebitOrders debitOrders) {
        return this.repository.update(debitOrders);
    }

    @Override
    public void delete(Double aDouble) {
    repository.delete(aDouble);
    }

    @Override
    public DebitOrders read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
