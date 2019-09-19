package ATMtrans.repository.Implement.accountImpl;

import ATMtrans.domain.account.Check;
import ATMtrans.factory.factoryAccount.CheckFactory;
import ATMtrans.repository.repositoryAccount.CheckRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckRepositoryImplTest {

    private CheckRepositoryImpl repository;
    private Check check;

    @Before
    public void setUp() throws Exception {
        this.repository= (CheckRepositoryImpl) CheckRepositoryImpl.getRepository();
        this.check = CheckFactory.getAmount(500);
    }

    @Test
    public void d_getAll() {
        Set<Check> check = this.repository.getAll();
        System.out.println("In get all," + check);
    }

    @Test
    public void create() {
        Check created = this.repository.create(this.check);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.check);
    }

    @Test
    public void update() {
        String newChechId = "002345";
        Check updated = new Check.Builder().Id(newChechId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newChechId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(check.getId());
        d_getAll();
    }

    @Test
    public void read() {

        Check read = this.repository.read(check.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,check);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}