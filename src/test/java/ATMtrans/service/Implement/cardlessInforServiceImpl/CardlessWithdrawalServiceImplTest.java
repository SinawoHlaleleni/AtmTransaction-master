package ATMtrans.service.Implement.cardlessInforServiceImpl;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.factory.factoryCardless.CardlessWithdrawalFactory;
import ATMtrans.repository.Implement.cardlessImpl.CardlessWithdrawalRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardlessWithdrawalServiceImplTest {

    private CardlessWithdrawalRepositoryImpl repository;
    private CardlessWithdrawal cardlessWithdrawal;

    @Before
    public void setUp() throws Exception {
        this.repository= CardlessWithdrawalRepositoryImpl.getRepository();
        this.cardlessWithdrawal= CardlessWithdrawalFactory.getAmount(1500);
    }

    @Test
    public void d_getAll() {

        Set<CardlessWithdrawal> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {

        CardlessWithdrawal created = this.repository.create(this.cardlessWithdrawal);
        System.out.println("the create, to be done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.cardlessWithdrawal);

    }

    @Test
    public void update() {

        String newUserName = "Unused user name";
        CardlessWithdrawal cardlessWithdrawal = new CardlessWithdrawal.Builder().Id(newUserName).build();
        System.out.println("the updates,to be done = " + cardlessWithdrawal );
        CardlessWithdrawal updated= this.repository.update(cardlessWithdrawal);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getId());
        d_getAll();

    }

    @Test
    public void delete() {
        this.repository.delete(cardlessWithdrawal.getId());
        d_getAll();

    }

    @Test
    public void read() {
        System.out.println("the read, done = " + cardlessWithdrawal.getId() );
        CardlessWithdrawal read = this.repository.read(cardlessWithdrawal.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(cardlessWithdrawal,read);
    }

}