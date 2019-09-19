package ATMtrans.service.bankInforService;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface BranchService extends IService <Branch,String> {
    Set<Branch> getAll();
}