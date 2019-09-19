package ATMtrans.service.accountService;

import ATMtrans.domain.account.Flexible;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface FlexibleService extends IService<Flexible,String> {
    Set<Flexible> getAll();
}
