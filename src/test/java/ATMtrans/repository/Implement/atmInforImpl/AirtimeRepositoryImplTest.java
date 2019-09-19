package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Airtime;
import ATMtrans.factory.factoryAtmInfor.AirtimeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AirtimeRepositoryImplTest {

    private AirtimeRepositoryImpl repository;
    private Airtime airtime;

    @Before
    public void setUp() throws Exception {
        this.repository= (AirtimeRepositoryImpl) AirtimeRepositoryImpl.getRepository();
        this.airtime = AirtimeFactory.getAmount( 1000 );
    }
    @Test
    public void d_getAll() {
        Set<Airtime> cashLimits = this.repository.getAll();
        System.out.println("In get all," + cashLimits);
    }

    @Test
    public void create() {
        Airtime created = this.repository.create(this.airtime);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.airtime);
    }

    @Test
    public void update() {
        String newEtymId = "002345";
        Airtime updated = new Airtime.Builder().tId(newEtymId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newEtymId,updated.gettId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(airtime.gettId());
        d_getAll();
    }

    @Test
    public void read() {
        Airtime read = this.repository.read(airtime.gettId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,airtime);
    }}