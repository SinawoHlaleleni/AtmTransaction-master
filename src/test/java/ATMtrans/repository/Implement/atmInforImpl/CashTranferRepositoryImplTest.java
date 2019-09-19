package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.CashTransfer;
import ATMtrans.factory.factoryAtmInfor.CashTransferFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CashTranferRepositoryImplTest {

    private CashTranferRepositoryImpl repository;
    private CashTransfer cashTransfer;


    @Before
    public void setUp() throws Exception {
        this.repository= (CashTranferRepositoryImpl) CashTranferRepositoryImpl.getRepository();
        this.cashTransfer = CashTransferFactory.getAmount( 1000 );
    }
    @Test
    public void d_getAll() {
        Set<CashTransfer> cashLimits = this.repository.getAll();
        System.out.println("In get all," + cashLimits);
    }

    @Test
    public void create() {
        CashTransfer created = this.repository.create(this.cashTransfer);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.cashTransfer);
    }

    @Test
    public void update() {
        String newCashLimiteId = "002345";
        CashTransfer updated = new CashTransfer.Builder().Id(newCashLimiteId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newCashLimiteId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(cashTransfer.getId());
        d_getAll();
    }

    @Test
    public void read() {
        CashTransfer read = this.repository.read(cashTransfer.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,cashTransfer);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}