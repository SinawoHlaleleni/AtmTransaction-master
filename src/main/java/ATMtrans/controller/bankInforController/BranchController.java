package ATMtrans.controller.bankInforController;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.factory.factoryBankInfor.BranchFactory;
import ATMtrans.service.Implement.bankServiceImpl.BranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("ATMtrans/branch")

public class BranchController {

    @Autowired
    private BranchServiceImpl service;

    @GetMapping("/create/{branchName}")
    public @ResponseBody
    Branch create (@PathVariable String branchName){
        Branch branch = BranchFactory.getName(branchName);
        return service.create(branch);

    }
    @GetMapping ("/getall")
    @ResponseBody
    public Set<Branch> getAll(){
        return service.getAll();
    }
}
