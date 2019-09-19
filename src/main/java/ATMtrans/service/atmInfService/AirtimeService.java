package ATMtrans.service.atmInfService;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface AirtimeService extends IService  <Airtime,Double> {
    Set<Airtime> getAll();
}