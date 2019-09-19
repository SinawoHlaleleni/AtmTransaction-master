package ATMtrans.repository.repositoryOrder;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface CreditOrderRepository extends IRepository<CreditOrder,Double> {
    Set<CreditOrder> getAll();
}

