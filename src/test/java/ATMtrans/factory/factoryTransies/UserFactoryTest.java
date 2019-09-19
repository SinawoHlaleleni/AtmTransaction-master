package ATMtrans.factory.factoryTransies;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.factory.factoryAtmTransies.UserFactory;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void getUser() {

        String username = "SinawoHlaleleni";
        String password = "12345";
        User s = UserFactory.getUser(username,password);
        System.out.println(s);
        Assert.assertNotNull(s.getUserId());
    }
}