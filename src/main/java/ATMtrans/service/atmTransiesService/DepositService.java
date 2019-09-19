package ATMtrans.service.atmTransiesService;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface DepositService extends IService <Deposit,Double> {
    Set<Deposit> getAll();
}