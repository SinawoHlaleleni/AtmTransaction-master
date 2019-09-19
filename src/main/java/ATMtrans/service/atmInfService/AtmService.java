package ATMtrans.service.atmInfService;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface AtmService extends IService <Atm,String> {
    Set<Atm> getAll();
}