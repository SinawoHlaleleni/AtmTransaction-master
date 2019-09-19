package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.repository.Implement.atmInforImpl.CashTranferRepositoryImpl;
import ATMtrans.repository.repositoryAtmInf.CashTranferRepository;
import ATMtrans.service.atmInfService.CashTransferService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CashTransferServiceImpl  implements CashTransferService {

    public static CashTransferServiceImpl service = null;
    private CashTranferRepository repository;

    private CashTransferServiceImpl(){
        this.repository= CashTranferRepositoryImpl.getRepository();
    }
    public static CashTransferServiceImpl getService(){
        if(service == null) service = new CashTransferServiceImpl();
        return service;
    }

    @Override
    public Set<CashTransfer> getAll() {
        return this.repository.getAll();
    }

    @Override
    public CashTransfer create(CashTransfer cashTransfer) {
        return this.repository.create(cashTransfer);
    }

    @Override
    public CashTransfer update(CashTransfer cashTransfer) {
        return this.repository.update(cashTransfer);
    }

    @Override
    public void delete(Double aDouble) {
        repository.delete(aDouble);
    }

    @Override
    public CashTransfer read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}
