package ATMtrans.service.atmInfService;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface CashLimitService extends IService <CashLimit,Double> {
    Set<CashLimit> getAll();
}