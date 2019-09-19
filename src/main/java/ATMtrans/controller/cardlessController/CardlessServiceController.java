package ATMtrans.controller.cardlessController;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.factory.factoryCardless.CardlessServiceFactory;
import ATMtrans.service.Implement.cardlessInforServiceImpl.CardlessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/cardlessService")

public class CardlessServiceController {
    @Autowired
    private CardlessServiceImpl service;

    @GetMapping("/create/{cardlessServiceType}")
    public @ResponseBody
    CardlessService create (@PathVariable String cardlessServiceType){
        CardlessService cardlessService = CardlessServiceFactory.getType(cardlessServiceType);
        return service.create(cardlessService);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<CardlessService> getAll(){
        return service.getAll();
    }

}
