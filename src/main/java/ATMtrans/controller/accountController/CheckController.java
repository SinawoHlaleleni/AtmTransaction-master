package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Check;
import ATMtrans.factory.factoryAccount.CheckFactory;
import ATMtrans.service.Implement.accountServiceImpl.CheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/check")

public class CheckController {

@Autowired
    private CheckServiceImpl service;

@GetMapping("/create/{checkAmount}")
    public @ResponseBody
    Check create (@PathVariable Double checkAmount){
    Check check = CheckFactory.getAmount(checkAmount);
    return service.create(check);

}
@GetMapping ("/getall")
    @ResponseBody
    public Set<Check>getAll(){
    return service.getAll();
}

}

