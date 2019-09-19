package ATMtrans.controller.ordersController;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.factory.factoryOrders.CreditOrderFactory;
import ATMtrans.service.Implement.orderServiceImpl.CreditOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/creditOrder")

public class CreditOrderController {

    @Autowired
    private CreditOrderServiceImpl service;

    @GetMapping("/create/{CreditOrderAmount}")
    public @ResponseBody
    CreditOrder create (@PathVariable Double ewalletAmount){
        CreditOrder creditOrder = CreditOrderFactory.getAmount(ewalletAmount);
        return service.create(creditOrder);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<CreditOrder> getAll(){
        return service.getAll();
    }

}
