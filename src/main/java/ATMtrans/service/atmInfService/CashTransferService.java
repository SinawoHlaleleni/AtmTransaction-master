package ATMtrans.service.atmInfService;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface CashTransferService extends IService <CashTransfer,Double> {
    Set<CashTransfer> getAll();
}