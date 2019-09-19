package ATMtrans.service.Implement.orderServiceImpl;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.repository.Implement.orderImpl.StopOrderRepositoryImpl;
import ATMtrans.repository.repositoryOrder.StopOrderRepository;
import ATMtrans.service.orderService.StopOrderService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class StopOrderServiceImpl implements StopOrderService {

    public static StopOrderServiceImpl service = null;
    private StopOrderRepository repository;

    private StopOrderServiceImpl(){
        this.repository= StopOrderRepositoryImpl.getRepository();
    }
    public static StopOrderServiceImpl getService(){
        if(service == null) service = new StopOrderServiceImpl();
        return service;
    }

    @Override
    public Set<StopOrder> getAll() {
        return this.repository.getAll();
    }

    @Override
    public StopOrder create(StopOrder stopOrder) {
        return this.repository.create(stopOrder);
    }

    @Override
    public StopOrder update(StopOrder stopOrder) {
        return this.repository.update(stopOrder);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public StopOrder read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
