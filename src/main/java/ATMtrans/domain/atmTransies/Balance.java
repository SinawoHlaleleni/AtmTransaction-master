package ATMtrans.domain.atmTransies;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Balance implements AtmTran {

    private String Id;
    private static double amount =5000;

    public String getId() {
        return Id;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private Balance(){}

    private Balance (Builder builder){

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
        public Builder copy(Balance balance){
            this.Id = balance.Id;
            this.amount =Balance.amount;
            return this;
        }

        public Balance build() {
            return new Balance(this);
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
        Balance balance = (Balance) obj;
        return balance.equals(balance.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

