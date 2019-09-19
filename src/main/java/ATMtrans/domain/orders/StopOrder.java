package ATMtrans.domain.orders;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class StopOrder implements DebitOrders {

    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private StopOrder(){}

    private StopOrder (Builder builder){

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
        public Builder copy(StopOrder stopOrder){
            this.Id = stopOrder.Id;
            this.amount = StopOrder.amount;
            return this;
        }

        public StopOrder build() {
            return new StopOrder(this);
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
        StopOrder stopOrder = (StopOrder) obj;
        return stopOrder.equals(stopOrder.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

