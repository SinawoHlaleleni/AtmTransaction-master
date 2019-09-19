package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.factory.factoryAtmInfor.CashLimitFactory;
import ATMtrans.service.Implement.atmInfServiceImpl.CashLimitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/c")

public class CashLimitController {

    @Autowired
    private CashLimitServiceImpl service;

    @GetMapping("/create/{cashLimitAmount}")
    public @ResponseBody
    CashLimit create (@PathVariable Double CashLimitAmount){
        CashLimit cashLimit = CashLimitFactory.getAmount(CashLimitAmount);
        return service.create(cashLimit);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<CashLimit> getAll(){
        return service.getAll();
    }


}


