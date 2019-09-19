package ATMtrans.service.accountService;

import ATMtrans.domain.account.Fixed;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface FixedService extends IService<Fixed,String> {
    Set<Fixed> getAll();
}
