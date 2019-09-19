package ATMtrans.service.orderService;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface StopOrderService extends IService <StopOrder,Double> {
    Set<StopOrder> getAll();
}
