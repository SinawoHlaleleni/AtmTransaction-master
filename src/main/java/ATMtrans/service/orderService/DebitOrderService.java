package ATMtrans.service.orderService;

import ATMtrans.domain.orders.DebitOrders;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface DebitOrderService extends IService <DebitOrders,Double> {
    Set<DebitOrders> getAll();
}