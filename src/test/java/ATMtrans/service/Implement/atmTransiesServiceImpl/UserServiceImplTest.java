package ATMtrans.service.Implement.atmTransiesServiceImpl;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.factory.factoryAtmTransies.UserFactory;
import ATMtrans.repository.Implement.atmTransiesImpl.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

    private UserRepositoryImpl repository;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.repository= (UserRepositoryImpl) UserRepositoryImpl.getRepository();
        this.user= UserFactory.getUser("Sinawo", "000458g");
    }

    @Test
    public void d_getAll() {
        Set<User> all =this.repository.getAll();
        System.out.println("In getall,all = " + all);
    }

    @Test
    public void create() {
        User created = this.repository.create(this.user);
        System.out.println("the create, to be done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.user);
    }

    @Test
    public void update() {
        String newUserName = "Unused user name";
        User user = new User.Builder().userId(newUserName).build();
        System.out.println("the updates,to be done = " + user );
        User updated= this.repository.update(user);
        System.out.println("the updates, done = " + updated );
        Assert.assertEquals(newUserName,updated.getUserId());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(user.getUserId());
        d_getAll();

    }

    @Test
    public void read() {
        System.out.println("the read, done = " + user.getUserId() );
        User read = this.repository.read(user.getUserId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(user,read);
    }
}