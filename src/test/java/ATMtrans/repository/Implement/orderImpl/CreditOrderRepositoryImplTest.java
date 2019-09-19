package ATMtrans.repository.Implement.orderImpl;

import ATMtrans.domain.orders.CreditOrder;
import ATMtrans.factory.factoryOrders.CreditOrderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreditOrderRepositoryImplTest {

    private CreditOrderRepositoryImpl repository;
    private CreditOrder creditOrder;

    @Before
    public void setUp() throws Exception {
        this.repository= (CreditOrderRepositoryImpl) CreditOrderRepositoryImpl.getRepository();
        this.creditOrder= CreditOrderFactory.getAmount(1200);

    }

    @Test
    public void d_getAll() {
        Set<CreditOrder> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);

    }

    @Test
    public void create() {

        CreditOrder created = this.repository.create(this.creditOrder);
        System.out.println("the create, to be done =" + created);
        d_getAll();
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.creditOrder);
    }

    @Test
    public void update() {
        String newUserName = "Unused user name";
        CreditOrder branch = new CreditOrder.Builder().Id(newUserName).build();
        System.out.println("the updates,to be done = " + branch );
        CreditOrder updated= this.repository.update(branch);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getId());
        d_getAll();

    }

    @Test
    public void delete() {
        this.repository.delete(creditOrder.getId());
        d_getAll();

    }

    @Test
    public void read() {
        System.out.println("the read, done = " + creditOrder.getId() );
        CreditOrder read = this.repository.read(creditOrder.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(creditOrder,read);

    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}