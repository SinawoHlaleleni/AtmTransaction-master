package ATMtrans.repository.repositoryOrder;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface StopOrderRepository extends IRepository<StopOrder,Double> {
    Set<StopOrder> getAll();
}

