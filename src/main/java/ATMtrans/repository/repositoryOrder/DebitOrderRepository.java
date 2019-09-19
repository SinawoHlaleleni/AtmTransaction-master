package ATMtrans.repository.repositoryOrder;

import ATMtrans.domain.orders.DebitOrders;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface DebitOrderRepository extends IRepository<DebitOrders,Double> {
    Set<DebitOrders> getAll();
}

