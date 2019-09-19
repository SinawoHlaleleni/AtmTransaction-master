package ATMtrans.controller.bankInforController;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.factory.factoryBankInfor.BankFactory;
import ATMtrans.service.Implement.bankServiceImpl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/bank")

public class BankController {

    @Autowired
    private BankServiceImpl service;

    @GetMapping("/create/{bankName}")
    public @ResponseBody
    Bank create (@PathVariable String bankName){
        Bank bank = BankFactory.getName(bankName);
        return service.create(bank);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Bank> getAll(){
        return service.getAll();
    }

}
