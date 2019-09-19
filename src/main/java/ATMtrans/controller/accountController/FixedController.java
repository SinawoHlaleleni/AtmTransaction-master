package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Fixed;
import ATMtrans.factory.factoryAccount.FixedFactory;
import ATMtrans.service.Implement.accountServiceImpl.FixedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/fixed")

public class FixedController {
    @Autowired
    private FixedServiceImpl service;

    @GetMapping("/create/{fixedAmount}")
    public @ResponseBody
    Fixed create (@PathVariable Double fixedAmount){
        Fixed fixed = FixedFactory.getAmount(fixedAmount);
        return service.create(fixed);

}
@GetMapping("/getall")
    @ResponseBody
    public Set<Fixed>getAll(){
        return service.getAll();
}
}

