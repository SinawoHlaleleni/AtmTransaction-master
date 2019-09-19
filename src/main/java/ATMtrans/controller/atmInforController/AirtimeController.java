package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.factory.factoryAtmInfor.AirtimeFactory;
import ATMtrans.service.Implement.atmInfServiceImpl.AirtimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/airtime")

public class AirtimeController {

    @Autowired
    private AirtimeServiceImpl service;

    @GetMapping("/create/{airtimeAmount}")
    public @ResponseBody
    Airtime create (@PathVariable Double AirtimeAmount){
        Airtime airtime = AirtimeFactory.getAmount(AirtimeAmount);
        return service.create(airtime);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Airtime> getAll(){
        return service.getAll();
    }

}
