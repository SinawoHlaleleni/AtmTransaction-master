package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.factory.factoryAtmInfor.TopupFactory;
import ATMtrans.service.Implement.atmInfServiceImpl.TopupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/topup")


public class TopupController {

    @Autowired
    private TopupServiceImpl service;

    @GetMapping("/create/{TopupType}")
    public @ResponseBody
    Topup create (@PathVariable String Type){
        Topup topup = TopupFactory.getType(Type);
        return service.create(topup);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Topup> getAll(){
        return service.getAll();
    }
}
