package ATMtrans.service.orderService;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface CreditOrderService extends IService <CreditOrder,Double> {
    Set<CreditOrder> getAll();
}