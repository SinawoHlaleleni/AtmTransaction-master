package ATMtrans.service.Implement.atmTransiesServiceImpl;

import ATMtrans.domain.atmTransies.Deposit;
import ATMtrans.factory.factoryAtmTransies.DepositFactory;
import ATMtrans.repository.Implement.atmTransiesImpl.DepositRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepositServiceImplTest {

    private DepositRepositoryImpl repository;
    private Deposit deposit;

    @Before
    public void setUp() throws Exception {
        this.repository= (DepositRepositoryImpl) DepositRepositoryImpl.getRepository();
        this.deposit= DepositFactory.getAmount(1500);
    }

    @Test
    public void d_getAll() {

        Set<Deposit> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {
        Deposit created = this.repository.create(this.deposit);
        System.out.println("the create, to be done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.deposit);

    }

    @Test
    public void update() {

        String newUserName = "Unused user name";
        Deposit deposit = new Deposit.Builder().Id(newUserName).build();
        System.out.println("the updates,to be done = " + deposit );
        Deposit updated= this.repository.update(deposit);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(deposit.getId());
        d_getAll();
    }

    @Test
    public void read() {
        System.out.println("the read, done = " + deposit.getId() );
        Deposit read = this.repository.read(deposit.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(deposit,read);

    }
}