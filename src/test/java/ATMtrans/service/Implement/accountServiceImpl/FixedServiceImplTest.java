package ATMtrans.service.Implement.accountServiceImpl;

import ATMtrans.domain.account.Fixed;
import ATMtrans.factory.factoryAccount.FixedFactory;
import ATMtrans.repository.Implement.accountImpl.FixedRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FixedServiceImplTest {

    private FixedRepositoryImpl repository;
    private Fixed fixed;

    @Before
    public void setUp() throws Exception {
        this.repository= (FixedRepositoryImpl) FixedRepositoryImpl.getRepository();
        this.fixed = FixedFactory.getAmount( 700 );
    }

    @Test
    public void d_getAll() {
        Set<Fixed> fixed = this.repository.getAll();
        System.out.println("In get all," + fixed);
    }

    @Test
    public void create() {
        Fixed created = this.repository.create(this.fixed);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.fixed);
    }

    @Test
    public void update() {
        String newFixedId = "002345";
        Fixed updated = new Fixed.Builder().Id(newFixedId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newFixedId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(fixed.getId());
        d_getAll();
    }

    @Test
    public void read() {
        Fixed read = this.repository.read(fixed.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,fixed);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}