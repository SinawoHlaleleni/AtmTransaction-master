package ATMtrans.domain.orders;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class CreditOrder implements DebitOrders {

    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private CreditOrder(){}

    private CreditOrder (Builder builder){

        this.Id= builder.Id;
        this.amount=builder.amount;

    }

    public static class Builder {
        private String Id;
        private double amount;

        public Builder Id(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }
        public Builder copy(CreditOrder creditOrder){
            this.Id = creditOrder.Id;
            this.amount = CreditOrder.amount;
            return this;
        }

        public CreditOrder build() {
            return new CreditOrder(this);
        }
    }
    @Override
    public String toString() {
        return "Builder{" +
                "Id='" + Id + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        CreditOrder creditOrder = (CreditOrder) obj;
        return creditOrder.equals(creditOrder.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

