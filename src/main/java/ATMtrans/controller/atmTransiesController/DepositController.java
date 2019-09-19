package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.factory.factoryAtmTransies.DepositFactory;
import ATMtrans.service.Implement.atmTransiesServiceImpl.DepositServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/deposit")

public class DepositController {
    @Autowired
    private DepositServiceImpl service;

    @GetMapping("/create/{depositAmount}")
    public @ResponseBody
    Deposit create (@PathVariable Double DepositAmount){
        Deposit deposit = DepositFactory.getAmount(DepositAmount);
        return service.create(deposit);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Deposit> getAll(){
        return service.getAll();
    }


}
