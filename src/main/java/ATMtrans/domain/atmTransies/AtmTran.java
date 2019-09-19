package ATMtrans.domain.atmTransies;
//import javafx.util.Builder;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public interface AtmTran  {

    double getAmount();


}
