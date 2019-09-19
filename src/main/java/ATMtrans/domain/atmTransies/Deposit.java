package ATMtrans.domain.atmTransies;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Deposit implements AtmTran {
    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private Deposit(){}

    private Deposit (Builder builder){

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
        public Builder copy(Deposit deposit){
            this.Id = deposit.Id;
            this.amount = Deposit.amount;
            return this;
        }

        public Deposit build() {
            return new Deposit(this);
        }
    }
    @Override
    public String toString() {
        return "Builder{" +
                "Id='" + Id + '\'' +
                ", Type='" + amount + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        Deposit deposit = (Deposit) obj;
        return deposit.equals(deposit.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

