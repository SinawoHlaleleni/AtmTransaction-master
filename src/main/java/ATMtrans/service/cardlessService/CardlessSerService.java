package ATMtrans.service.cardlessService;

import ATMtrans.domain.cardless.CardlessService;
import ATMtrans.service.IService.IService;

import java.util.Set;

public interface CardlessSerService extends IService <CardlessService,Double> {
    Set<CardlessService> getAll();
}
