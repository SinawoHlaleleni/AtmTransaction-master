package ATMtrans.domain.orders;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public interface DebitOrders {

    double getAmount();

}
