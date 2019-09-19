package ATMtrans.repository.Implement.cardlessImpl;

import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.repository.repositoryCardless.CardlessWithdrawalRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class CardlessWithdrawalRepositoryImpl implements CardlessWithdrawalRepository {
    public static CardlessWithdrawalRepositoryImpl repository = null;
    private Set<CardlessWithdrawal> cardlessWithdrawals;

    private CardlessWithdrawalRepositoryImpl() {
        cardlessWithdrawals = new HashSet<>();
    }

    private CardlessWithdrawal findCardlessWithdrawal(String Id){
        return this.cardlessWithdrawals.stream()
                .filter( cardlessWithdrawal -> cardlessWithdrawal.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static CardlessWithdrawalRepositoryImpl getRepository(){
        if (repository == null) repository = new CardlessWithdrawalRepositoryImpl();
        return repository;
    }

    @Override
    public Set<CardlessWithdrawal> getAll() {
        return this.cardlessWithdrawals;
    }

    @Override
    public CardlessWithdrawal create(CardlessWithdrawal cardlessWithdrawal) {
        this.cardlessWithdrawals.add( cardlessWithdrawal );
        return cardlessWithdrawal;
    }

    @Override
    public CardlessWithdrawal update(CardlessWithdrawal cardlessWithdrawal) {
        CardlessWithdrawal toUpdate = findCardlessWithdrawal( cardlessWithdrawal.getId() );
        if(toUpdate != null){
            this.cardlessWithdrawals.remove( toUpdate );
            return create(cardlessWithdrawal );
        }
        return null;
    }

    @Override
    public void delete(Double aDouble) {

    }

    @Override
    public CardlessWithdrawal read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        CardlessWithdrawal cardlessWithdrawal = findCardlessWithdrawal( Id );
        if(cardlessWithdrawal != null) this.cardlessWithdrawals.remove( cardlessWithdrawal);
    }

    public CardlessWithdrawal read(String Id) {
        CardlessWithdrawal cardlessWithdrawal = findCardlessWithdrawal( Id );
        return cardlessWithdrawal;
    }
}
