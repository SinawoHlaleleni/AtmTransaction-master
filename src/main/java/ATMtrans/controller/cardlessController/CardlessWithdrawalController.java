package ATMtrans.controller.cardlessController;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.factory.factoryCardless.CardlessWithdrawalFactory;
import ATMtrans.service.Implement.cardlessInforServiceImpl.CardlessWithdrawalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/cardlessWithdrawal")

public class CardlessWithdrawalController {

    @Autowired
    private CardlessWithdrawalServiceImpl service;

    @GetMapping("/create/{branchName}")
    public @ResponseBody
    CardlessWithdrawal create (@PathVariable Double cardlessWithdrawalAmount){
        CardlessWithdrawal cardlessWithdrawal = CardlessWithdrawalFactory.getAmount(cardlessWithdrawalAmount);
        return service.create(cardlessWithdrawal);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<CardlessWithdrawal> getAll(){
        return service.getAll();
    }

}
