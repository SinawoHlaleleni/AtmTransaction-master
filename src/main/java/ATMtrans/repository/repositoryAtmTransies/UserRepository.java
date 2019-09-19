package ATMtrans.repository.repositoryAtmTransies;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface UserRepository extends IRepository<User,String> {
    Set<User> getAll();
   // User create(User user);


}
