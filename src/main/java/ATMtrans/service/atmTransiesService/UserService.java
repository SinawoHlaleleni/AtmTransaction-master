package ATMtrans.service.atmTransiesService;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.service.IService.IService;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UserService extends IService <User,String> {
    Set<User> getAll();
    // User create(User user);


}