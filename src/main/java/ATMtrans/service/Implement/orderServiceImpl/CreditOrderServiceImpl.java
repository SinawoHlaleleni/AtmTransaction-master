package ATMtrans.service.Implement.orderServiceImpl;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.repository.Implement.orderImpl.CreditOrderRepositoryImpl;
import ATMtrans.repository.repositoryOrder.CreditOrderRepository;
import ATMtrans.service.orderService.CreditOrderService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CreditOrderServiceImpl implements CreditOrderService {

    public static CreditOrderServiceImpl service = null;
    private CreditOrderRepository repository;

    private CreditOrderServiceImpl(){
        this.repository= CreditOrderRepositoryImpl.getRepository();
    }
    public static CreditOrderServiceImpl getService(){
        if(service == null) service = new CreditOrderServiceImpl();
        return service;
    }

    @Override
    public Set<CreditOrder> getAll() {
        return this.repository.getAll();
    }

    @Override
    public CreditOrder create(CreditOrder creditOrder) {
        return this.repository.create(creditOrder);
    }

    @Override
    public CreditOrder update(CreditOrder creditOrder) {
        return this.repository.update(creditOrder);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public CreditOrder read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
