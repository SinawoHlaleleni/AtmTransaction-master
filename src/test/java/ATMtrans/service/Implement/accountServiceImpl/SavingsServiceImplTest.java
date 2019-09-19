package ATMtrans.service.Implement.accountServiceImpl;

import ATMtrans.domain.account.Savings;
import ATMtrans.factory.factoryAccount.SavingsFactory;
import ATMtrans.repository.Implement.accountImpl.SavingRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;
import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SavingsServiceImplTest {

    private SavingRepositoryImpl repository;
    private Savings savings;


    @Before
    public void setUp() throws Exception {
        this.repository= SavingRepositoryImpl.getRepository();
        this.savings = SavingsFactory.getAmount( 500 );
    }

    @Test
    public void d_getAll() {
        Set<Savings> savings = this.repository.getAll();
        System.out.println("In get all," + savings);
    }

    @Test
    public void create() {
        Savings created = this.repository.create(this.savings);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.savings);
    }

    @Test
    public void update() {
        String newSavingId = "002345";
        Savings updated = new Savings.Builder().Id(newSavingId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newSavingId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(savings.getId());
        d_getAll();
    }

    @Test
    public void read() {

        Savings read = this.repository.read(savings.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,savings);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}