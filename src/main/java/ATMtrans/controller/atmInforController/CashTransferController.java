package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.factory.factoryAtmInfor.CashTransferFactory;
import ATMtrans.service.Implement.atmInfServiceImpl.CashTransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/cashTransfer")

public class CashTransferController {

    @Autowired
    private CashTransferServiceImpl service;

    @GetMapping("/create/{cashTransferAmount}")
    public @ResponseBody
    CashTransfer create (@PathVariable Double CashTransferAmount){
        CashTransfer cashTransfer = CashTransferFactory.getAmount(CashTransferAmount);
        return service.create(cashTransfer);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<CashTransfer> getAll(){
        return service.getAll();
    }


}
