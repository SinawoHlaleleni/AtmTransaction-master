package ATMtrans.service.Implement.bankServiceImpl;

import ATMtrans.domain.bankInfor.Branch;
import ATMtrans.factory.factoryBankInfor.BranchFactory;
import ATMtrans.repository.Implement.bankInforImpl.BranchRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BranchServiceImplTest {

    private BranchRepositoryImpl repository;
    private Branch branch;

    @Before
    public void setUp() throws Exception {
        this.repository= (BranchRepositoryImpl) BranchRepositoryImpl.getRepository();
        this.branch= BranchFactory.getName("Cnr cpt Absa");
    }

    @Test
    public void d_getAll() {
        Set<Branch> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {

        Branch created = this.repository.create(this.branch);
        System.out.println("the create, to be done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.branch);

    }

    @Test
    public void update() {

        String newUserName = "Unused user name";
        Branch branch = new Branch.Builder().Id(newUserName).build();
        System.out.println("the updates,to be done = " + branch );
        Branch updated= this.repository.update(branch);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getId());
        d_getAll();

    }

    @Test
    public void delete() {
        this.repository.delete(branch.getId());
        d_getAll();

    }

    @Test
    public void read() {
        System.out.println("the read, done = " + branch.getId() );
        Branch read = this.repository.read(branch.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(branch,read);

    }
}