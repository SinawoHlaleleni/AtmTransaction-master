package ATMtrans.service.atmTransiesService;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface WithdrawalService extends IService <Withdrawal,Double> {
    Set<Withdrawal> getAll();
}