package ATMtrans.controller.atmTransiesController;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.factory.factoryAtmTransies.WithdrawalFactory;
import ATMtrans.service.Implement.atmTransiesServiceImpl.WithdrawalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/withdrawal")

public class WithdrawalController {

    @Autowired
    private WithdrawalServiceImpl service;

    @GetMapping("/create/{withdrawalAmount}")
    public @ResponseBody
    Withdrawal create (@PathVariable Double ElectricityAmount){
        Withdrawal withdrawal = WithdrawalFactory.getAmount(ElectricityAmount);
        return service.create(withdrawal);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Withdrawal> getAll(){
        return service.getAll();
    }


}
