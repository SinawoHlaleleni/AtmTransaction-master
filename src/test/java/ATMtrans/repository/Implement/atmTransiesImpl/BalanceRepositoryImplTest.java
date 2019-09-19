package ATMtrans.repository.Implement.atmTransiesImpl;

import ATMtrans.domain.atmTransies.Balance;
import ATMtrans.factory.factoryAtmTransies.BalanceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalanceRepositoryImplTest {

    private BalanceRepositoryImpl repository;
    private Balance balance;

    @Before
    public void setUp() throws Exception {
        this.repository= (BalanceRepositoryImpl) BalanceRepositoryImpl.getRepository();
        this.balance= BalanceFactory.getAmount(1500);
        }

    @Test
    public void d_getAll() {
        Set<Balance> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {

        Balance created = this.repository.create(this.balance);
        System.out.println("the create, to be done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.balance);
    }

    @Test
    public void update() {

        String newUserName = "Unused user name";
        Balance balance = new Balance.Builder().Id(newUserName).build();
        System.out.println("the updates,to be done = " + balance );
        Balance updated= this.repository.update(balance);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getId());
        d_getAll();
    }
    @Test
    public void delete() {
        this.repository.delete(balance.getId());
        d_getAll();
    }
    @Test
    public void read() {

        System.out.println("the read, done = " +balance.getId() );
        Balance read = this.repository.read(balance.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(balance,read);
    }
    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}