package ATMtrans.service.bankInforService;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface BankService extends IService <Bank,String> {
    Set<Bank> getAll();
}