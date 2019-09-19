package ATMtrans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmTransactionController {
    @GetMapping
    @ResponseBody
    public String getAtm(){
        return "ATM is working!";
    }
}
