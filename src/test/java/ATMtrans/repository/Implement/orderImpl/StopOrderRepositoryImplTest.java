package ATMtrans.repository.Implement.orderImpl;

import ATMtrans.domain.orders.StopOrder;
import ATMtrans.factory.factoryOrders.StopOrderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StopOrderRepositoryImplTest {

    private StopOrderRepositoryImpl repository;
    private StopOrder stopOrder;

    @Before
    public void setUp() throws Exception {
        this.repository= (StopOrderRepositoryImpl) StopOrderRepositoryImpl.getRepository();
        this.stopOrder = StopOrderFactory.getAmount( 1000 );
    }
    @Test
    public void d_getAll() {
        Set<StopOrder> stopOrder = this.repository.getAll();
        System.out.println("In get all," + stopOrder);
    }

    @Test
    public void create() {
        StopOrder created = this.repository.create(this.stopOrder);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.stopOrder);
    }

    @Test
    public void update() {
        String newCashLimiteId = "002345";
        StopOrder updated = new StopOrder.Builder().Id(newCashLimiteId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newCashLimiteId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(stopOrder.getId());
        d_getAll();
    }

    @Test
    public void read() {
        StopOrder read = this.repository.read(stopOrder.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,stopOrder);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}