package ATMtrans.repository.Implement.atmTransiesImpl;

import ATMtrans.domain.atmTransies.Withdrawal;
import ATMtrans.factory.factoryAtmTransies.WithdrawalFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WithdrawalRepositoryImplTest {

    private WithdrawalRepositoryImpl repository;
    private Withdrawal withdrawal;

    @Before
    public void setUp() throws Exception {
        this.repository= (WithdrawalRepositoryImpl) WithdrawalRepositoryImpl.getRepository();
        this.withdrawal= WithdrawalFactory.getAmount(1500);
    }

    @Test
    public void d_getAll() {
        Set<Withdrawal> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {
        Withdrawal created = this.repository.create(this.withdrawal);
        System.out.println("the create, to be done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.withdrawal);
    }

    @Test
    public void update() {

        String newUserName = "Unused user name";
        Withdrawal withdrawal = new Withdrawal.Builder().Id(newUserName).build();
        System.out.println("the updates,to be done = " + withdrawal );
        Withdrawal updated= this.repository.update(withdrawal);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(withdrawal.getId());
        d_getAll();
    }

    @Test
    public void read() {

        System.out.println("the read, done = " + withdrawal.getId() );
        Withdrawal read = this.repository.read(withdrawal.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(withdrawal,read);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}