package ATMtrans.service.accountService;

import ATMtrans.domain.account.Check;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface CheckService extends IService<Check,String> {
    Set<Check> getAll();
}
