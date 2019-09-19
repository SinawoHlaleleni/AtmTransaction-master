package ATMtrans.controller.cardlessController;

import ATMtrans.domain.cardless.Ewallet;
import ATMtrans.factory.factoryCardless.EwalletFactory;
import ATMtrans.service.Implement.cardlessInforServiceImpl.EwalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/ewallet")

public class EwalletController {

    @Autowired
    private EwalletServiceImpl service;

    @GetMapping("/create/{ewalletAmount}")
    public @ResponseBody
    Ewallet create (@PathVariable Double ewalletAmount){
        Ewallet ewallet = EwalletFactory.getAmount(ewalletAmount);
        return service.create(ewallet);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Ewallet> getAll(){
        return service.getAll();
    }

}
