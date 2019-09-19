package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Atm;
import ATMtrans.factory.factoryAtmInfor.AtmFactory;
import ATMtrans.service.Implement.atmInfServiceImpl.AtmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/atm")

public class AtmController {

    @Autowired
    private AtmServiceImpl service;

    @GetMapping("/create/{atmAmount}")
    public @ResponseBody
    Atm create (@PathVariable String Type){
        Atm atm = AtmFactory.getType(Type);
        return service.create(atm);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Atm> getAll(){
        return service.getAll();
    }


}
