package ATMtrans.service.atmTransiesService;

import ATMtrans.domain.atmTransies.AtmTran;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface AtmTranService extends IService <AtmTran,Double> {
    Set<AtmTran> getAll();
}