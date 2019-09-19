package ATMtrans.domain.account;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public interface Account {

    double getAmount();
}
