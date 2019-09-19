package ATMtrans.service.Implement.bankServiceImpl;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.repository.Implement.bankInforImpl.BranchRepositoryImpl;
import ATMtrans.repository.repositoryBankInfor.BranchRepository;
import ATMtrans.service.bankInforService.BranchService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class BranchServiceImpl implements BranchService {

    public static BranchServiceImpl service = null;
    private BranchRepository repository;

    private BranchServiceImpl(){
        this.repository= BranchRepositoryImpl.getRepository();
    }
    public static BranchServiceImpl getService(){
        if(service == null) service = new BranchServiceImpl();
        return service;
    }

    @Override
    public Set<Branch> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Branch create(Branch branch) {
        return this.repository.create(branch);
    }

    @Override
    public Branch update(Branch branch) {
        return this.repository.update(branch);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Branch read(String s) {
        return this.repository.read(s);
    }
}
