package ATMtrans.service.cardlessService;

import ATMtrans.domain.cardless.Ewallet;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface EwalletService extends IService <Ewallet,Double> {
    Set<Ewallet> getAll();
}