package ATMtrans.service.Implement.atmTransiesServiceImpl;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.repository.Implement.atmTransiesImpl.UserRepositoryImpl;
import ATMtrans.repository.repositoryAtmTransies.UserRepository;
import ATMtrans.service.atmTransiesService.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    public static UserServiceImpl service = null;
    private UserRepository repository;

    private UserServiceImpl(){
        this.repository= UserRepositoryImpl.getRepository();
    }
    public static UserServiceImpl getService(){
        if(service == null) service = new UserServiceImpl();
        return service;
    }

    @Override
    public Set<User> getAll() {
        return this.repository.getAll();
    }

    @Override
    public User create(User user) {
        return this.repository.create(user);
    }

    @Override
    public User update(User user) {
        return this.repository.update(user);
    }

    @Override
    public void delete(String s) {
    repository.delete(s);
    }

    @Override
    public User read(String s) {
        return this.repository.read(s);
    }
}
