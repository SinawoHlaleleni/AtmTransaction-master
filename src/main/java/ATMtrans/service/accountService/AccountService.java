package ATMtrans.service.accountService;


import ATMtrans.domain.account.Account;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface AccountService extends IService<Account,Double> {
    Set<Account> getAll();
}




