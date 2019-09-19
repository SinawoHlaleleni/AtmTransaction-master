package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Flexible;
import ATMtrans.factory.factoryAccount.FlexibleFactory;
import ATMtrans.service.Implement.accountServiceImpl.FlexibleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/Flexible")

public class FlexibleController {

    @Autowired
    private FlexibleServiceImpl service;

    @GetMapping("/create/{flexibleAmount}")
    public @ResponseBody
    Flexible create (@PathVariable Double FlexibleAmount){
        Flexible flexible = FlexibleFactory.getAmount(FlexibleAmount);
        return service.create(flexible);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Flexible> getAll(){
        return service.getAll();
    }

}
