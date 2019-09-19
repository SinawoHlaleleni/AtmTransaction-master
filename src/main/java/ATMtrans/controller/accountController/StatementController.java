package ATMtrans.controller.accountController;

import ATMtrans.domain.account.Statement;
import ATMtrans.factory.factoryAccount.StatementFactory;
import ATMtrans.service.Implement.accountServiceImpl.StatementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/Statement")

public class StatementController {

    @Autowired
    private StatementServiceImpl service;

    @GetMapping("/create/{statementAmount}")
    public @ResponseBody
    Statement create (@PathVariable String StatementType){
        Statement statement = StatementFactory.getType(StatementType);
        return service.create(statement);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Statement> getAll(){
        return service.getAll();
    }
}
