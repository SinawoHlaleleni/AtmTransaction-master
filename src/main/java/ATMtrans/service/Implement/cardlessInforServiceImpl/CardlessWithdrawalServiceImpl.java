package ATMtrans.service.Implement.cardlessInforServiceImpl;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.domain.cardless.CardlessWithdrawal;
import ATMtrans.repository.Implement.cardlessImpl.CardlessWithdrawalRepositoryImpl;
import ATMtrans.repository.repositoryCardless.CardlessWithdrawalRepository;
import ATMtrans.service.cardlessService.CardlessSerService;
import ATMtrans.service.cardlessService.CardlessWithdrawalService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CardlessWithdrawalServiceImpl implements CardlessWithdrawalService {

    public static CardlessWithdrawalServiceImpl service = null;
    private CardlessWithdrawalRepository repository;

    private CardlessWithdrawalServiceImpl() {
        this.repository = CardlessWithdrawalRepositoryImpl.getRepository();
    }

    public static CardlessWithdrawalServiceImpl getService() {
        if (service == null) service = new CardlessWithdrawalServiceImpl();
        return service;
    }

    @Override
    public Set<CardlessWithdrawal> getAll() {
        return this.repository.getAll();
    }

    @Override
    public CardlessWithdrawal create(CardlessWithdrawal cardlessWithdrawal) {
        return this.repository.create(cardlessWithdrawal);
    }

    @Override
    public CardlessWithdrawal update(CardlessWithdrawal cardlessWithdrawal) {
        return this.repository.update(cardlessWithdrawal);
    }

    @Override
    public void delete(Double aDouble) {
    repository.delete(aDouble);
    }

    @Override
    public CardlessWithdrawal read(Double aDouble) {
        return this.repository.read(aDouble);
    }
}