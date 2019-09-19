package ATMtrans.repository.Implement.atmTransiesImpl;

import ATMtrans.domain.atmTransies.User;
import ATMtrans.repository.repositoryAtmTransies.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class UserRepositoryImpl implements UserRepository {

    public static UserRepositoryImpl repository = null;
    private Set<User> users;

    private UserRepositoryImpl() {
        users = new HashSet<>();
    }
    private User findUser(String userId){
        return this.users.stream()
                .filter( user -> user.getUserId().trim().equals( userId ) )
                .findAny()
                .orElse( null );
    }

    public static UserRepository getRepository(){
        if (repository == null) repository = new UserRepositoryImpl();
        return repository;
    }

    @Override
    public Set<User> getAll() {
        return this.users;
    }

    @Override
    public User create(User user) {
        this.users.add( user );
        return user;
    }

    @Override
    public void delete(String userId) {
        User user = findUser( userId );
        if(user != null) this.users.remove( user );
    }

    @Override
    public User update(User user) {
        User toUpdate = findUser( user.getUserId() );
        if (toUpdate != null){
            this.users.remove( toUpdate );
            return create(user);
        }
        return null;
    }

    @Override
    public User read(final String userId)
    {
        User user = findUser( userId );
        return user;
    }
}
