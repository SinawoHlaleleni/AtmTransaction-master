package ATMtrans.service.atmInfService;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface TopupService extends IService <Topup,Double> {
    Set<Topup> getAll();
}