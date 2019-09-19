package ATMtrans.repository.Implement.cardlessImpl;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.factory.factoryCardless.CardlessServiceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardlessServiceRepositoryImplTest {

    private CardlessServiceRepositoryImpl repository;
    private CardlessService cardlessService;

    @Before
    public void setUp() throws Exception {
        this.repository= CardlessServiceRepositoryImpl.getRepository();
        this.cardlessService = CardlessServiceFactory.getType( "..." );
    }
    @Test
    public void d_getAll() {
        Set<CardlessService> cashLimits = this.repository.getAll();
        System.out.println("In get all," + cashLimits);
    }

    @Test
    public void create() {
        CardlessService created = this.repository.create(this.cardlessService);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.cardlessService);
    }

    @Test
    public void update() {
        String newCardlId = "002345";
        CardlessService updated = new CardlessService.Builder().Id(newCardlId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newCardlId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(cardlessService.getId());
        d_getAll();
    }

    @Test
    public void read() {
        CardlessService read = this.repository.read(cardlessService.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,cardlessService);
    }

    @Test
    public void delete1() {
    }

    @Test
    public void read1() {
    }
}