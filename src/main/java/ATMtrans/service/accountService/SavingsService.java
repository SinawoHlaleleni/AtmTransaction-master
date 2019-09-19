package ATMtrans.service.accountService;

import ATMtrans.domain.account.Savings;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface SavingsService extends IService <Savings,String>{
    Set<Savings> getAll();
}
