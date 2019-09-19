package ATMtrans.repository.Implement.atmInforImpl;

import ATMtrans.domain.atmInfor.Topup;
import ATMtrans.factory.factoryAtmInfor.TopupFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TopupRepositoryImplTest {

    private TopupRepositoryImpl repository;
    private Topup topup;

    @Before
    public void setUp() throws Exception {
        this.repository= (TopupRepositoryImpl) TopupRepositoryImpl.getRepository();
        this.topup = TopupFactory.getType( "Message" );
    }
    @Test
    public void d_getAll() {
        Set<Topup> cashLimits = this.repository.getAll();
        System.out.println("In get all," + cashLimits);
    }

    @Test
    public void create() {
        Topup created = this.repository.create(this.topup);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.topup);
    }

    @Test
    public void update() {
        String newTopId = "002345";
        Topup updated = new Topup.Builder().Id(newTopId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newTopId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(topup.getId());
        d_getAll();
    }

    @Test
    public void read() {
        Topup read = this.repository.read(topup.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,topup);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}