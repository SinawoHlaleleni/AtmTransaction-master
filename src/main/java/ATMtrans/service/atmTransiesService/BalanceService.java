package ATMtrans.service.atmTransiesService;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface BalanceService extends IService <Balance,Double> {
    Set<Balance> getAll();
}