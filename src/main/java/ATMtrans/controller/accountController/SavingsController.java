package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Savings;
import ATMtrans.factory.factoryAccount.SavingsFactory;
import ATMtrans.service.Implement.accountServiceImpl.SavingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/Savings")

public class SavingsController {

    @Autowired
    private SavingsServiceImpl service;

    @GetMapping("/create/{savingsAmount}")
    public @ResponseBody
    Savings create (@PathVariable Double SavingsAmount){
        Savings savings = SavingsFactory.getAmount(SavingsAmount);
        return service.create(savings);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Savings> getAll(){
        return service.getAll();
    }

}
