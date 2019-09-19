package ATMtrans.controller.ordersController;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.factory.factoryOrders.StopOrderFactory;
import ATMtrans.service.Implement.orderServiceImpl.StopOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/stopOrder")

public class StopOrderController {

    @Autowired
    private StopOrderServiceImpl service;

    @GetMapping("/create/{stopOrderAmount}")
    public @ResponseBody
    StopOrder create (@PathVariable Double ewalletAmount){
        StopOrder stopOrder = StopOrderFactory.getAmount(ewalletAmount);
        return service.create(stopOrder);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<StopOrder> getAll(){
        return service.getAll();
    }

}


