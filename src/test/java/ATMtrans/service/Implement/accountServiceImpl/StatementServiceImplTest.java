package ATMtrans.service.Implement.accountServiceImpl;

import ATMtrans.domain.account.Statement;
import ATMtrans.factory.factoryAccount.StatementFactory;
import ATMtrans.repository.Implement.accountImpl.StatementRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StatementServiceImplTest {

    private StatementRepositoryImpl repository;
    private Statement statement;

    @Before
    public void setUp() throws Exception {
        this.repository= (StatementRepositoryImpl) StatementRepositoryImpl.getRepository();
        this.statement = StatementFactory.getType( "6 Months" );
    }

    @Test
    public void d_getAll() {
        Set<Statement> statements = this.repository.getAll();
        System.out.println("In get all," + statements);
    }

    @Test
    public void create() {
        Statement created = this.repository.create(this.statement);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.statement);
    }

    @Test
    public void update() {
        String newStatemId = "002345";
        Statement updated = new Statement.Builder().id(newStatemId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertSame(newStatemId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(statement.getId());
        d_getAll();
    }

    @Test
    public void read() {
        Statement read = this.repository.read(statement.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,statement);
    }
}