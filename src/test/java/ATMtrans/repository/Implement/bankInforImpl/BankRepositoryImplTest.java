package ATMtrans.repository.Implement.bankInforImpl;

import ATMtrans.domain.bankInfor.Bank;
import ATMtrans.factory.factoryBankInfor.BankFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankRepositoryImplTest {

    private BankRepositoryImpl repository;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        this.repository= BankRepositoryImpl.getRepository();
        this.bank= BankFactory.getName("ABSAS");
    }

    @Test
    public void d_getAll() {
        Set<Bank> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {
        Bank created = this.repository.create(this.bank);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.bank);
    }

    @Test
    public void update() {

        String newBankName = "Unused bank name";
        Bank bank = new Bank.Builder().Id(newBankName).build();
        System.out.println("the update,to be done = " + bank );
        Bank updated = this.repository.update(bank);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newBankName,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(bank.getId());
        d_getAll();
    }

    @Test
    public void read() {
        Bank read = this.repository.read(bank.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,bank);
    }
}