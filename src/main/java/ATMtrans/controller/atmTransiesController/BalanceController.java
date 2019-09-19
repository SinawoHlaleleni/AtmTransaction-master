package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.factory.factoryAtmTransies.BalanceFactory;
import ATMtrans.service.Implement.atmTransiesServiceImpl.BalanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/balance")

public class BalanceController {
    @Autowired
    private BalanceServiceImpl service;

    @GetMapping("/create/{balanceAmount}")
    public @ResponseBody
    Balance create (@PathVariable Double BalanceAmount){
        Balance balance = BalanceFactory.getAmount(BalanceAmount);
        return service.create(balance);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Balance> getAll(){
        return service.getAll();
    }


}
