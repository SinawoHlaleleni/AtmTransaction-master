package ATMtrans.repository.Implement.cardlessImpl;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.repository.repositoryCardless.CardlessServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class CardlessServiceRepositoryImpl implements CardlessServiceRepository {

    public static CardlessServiceRepositoryImpl repository = null;
    private Set<CardlessService> cardlessServices;

    private CardlessServiceRepositoryImpl() {
        cardlessServices = new HashSet<>();
    }

    private CardlessService findCardlessService(String Id){
        return this.cardlessServices.stream()
                .filter( cardlessService -> cardlessService.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }
    public static CardlessServiceRepositoryImpl getRepository(){
        if (repository == null) repository = new CardlessServiceRepositoryImpl();
        return repository;
    }
    @Override
    public Set<CardlessService> getAll() {
        return this.cardlessServices;
    }

    @Override
    public CardlessService create(CardlessService cardlessService) {
        this.cardlessServices.add( cardlessService );
        return cardlessService;

    }

    @Override
    public CardlessService update(CardlessService cardlessService) {
        CardlessService toUpdate = findCardlessService( cardlessService.getId() );
        if(toUpdate != null){
            this.cardlessServices.remove( toUpdate );
            return create(cardlessService );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public CardlessService read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        CardlessService cardlessService = findCardlessService( Id );
        if(cardlessService != null) this.cardlessServices.remove( cardlessService );
    }

    public CardlessService read(String Id) {
        CardlessService cardlessService = findCardlessService( Id );
        return cardlessService;
    }
}
