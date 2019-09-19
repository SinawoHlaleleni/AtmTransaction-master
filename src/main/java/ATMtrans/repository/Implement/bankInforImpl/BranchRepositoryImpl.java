package ATMtrans.repository.Implement.bankInforImpl;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.repository.repositoryBankInfor.BranchRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class BranchRepositoryImpl implements BranchRepository {
    public static BranchRepositoryImpl repository = null;
    private Set<Branch> branchs;

    private BranchRepositoryImpl() {
        branchs = new HashSet<>();
    }

    private Branch findBranch(String Id){
        return this.branchs.stream()
                .filter( branch -> branch.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static BranchRepository getRepository(){
        if (repository == null) repository = new BranchRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Branch> getAll() {
        return this.branchs;
    }

    @Override
    public Branch create(Branch branch) {
        this.branchs.add( branch );
        return branch;
    }
    @Override
    public Branch update(Branch branch) {
       Branch toUpdate = findBranch( branch.getId() );
        if(toUpdate != null){
            this.branchs.remove( toUpdate );
            return create(branch );
        }
        return null;
    }

    @Override
    public void delete(String Id) {
        Branch branch = findBranch( Id );
        if(branch != null) this.branchs.remove( branch );
    }
    @Override
    public Branch read(String Id)
    {
        Branch branch = findBranch( Id );
        return branch;
    }
}