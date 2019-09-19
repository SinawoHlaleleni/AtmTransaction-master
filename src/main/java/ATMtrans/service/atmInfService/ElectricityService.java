package ATMtrans.service.atmInfService;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface ElectricityService extends IService <Electricity,String> {
    Set<Electricity> getAll();
}