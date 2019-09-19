package ATMtrans.controller.atmInforController;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.factory.factoryAtmInfor.ElectricityFactory;
import ATMtrans.service.Implement.atmInfServiceImpl.ElectricityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/electricity")


public class ElectricityController {

    @Autowired
    private ElectricityServiceImpl service;

    @GetMapping("/create/{electricityAmount}")
    public @ResponseBody
    Electricity create (@PathVariable Double ElectricityAmount){
        Electricity electricity = ElectricityFactory.getAmount(ElectricityAmount);
        return service.create(electricity);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Electricity> getAll(){
        return service.getAll();
    }

}
