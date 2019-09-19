package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.CashLimit;
import ATMtrans.factory.factoryAtmInfor.CashLimitFactory;
import ATMtrans.repository.Implement.atmInforImpl.CashLimitRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CashLimitServiceImplTest {

    private CashLimitRepositoryImpl repository;
    private CashLimit cashLimit;


    @Before
    public void setUp() throws Exception {
        this.repository= (CashLimitRepositoryImpl) CashLimitRepositoryImpl.getRepository();
        this.cashLimit = CashLimitFactory.getAmount( 1000 );
    }
    @Test
    public void d_getAll() {
        Set<CashLimit> cashLimits = this.repository.getAll();
        System.out.println("In get all," + cashLimits);
    }

    @Test
    public void create() {
        CashLimit created = this.repository.create(this.cashLimit);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.cashLimit);
    }

    @Test
    public void update() {
        String newCashLimiteId = "002345";
        CashLimit updated = new CashLimit.Builder().Id(newCashLimiteId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newCashLimiteId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(cashLimit.getId());
        d_getAll();
    }

    @Test
    public void read() {
        CashLimit read = this.repository.read(cashLimit.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,cashLimit);
    }

}