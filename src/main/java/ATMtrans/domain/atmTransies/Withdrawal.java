package ATMtrans.domain.atmTransies;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Withdrawal implements AtmTran {

    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private Withdrawal(){}

    private Withdrawal (Builder builder){

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
        public Builder copy(Withdrawal withdrawal){
            this.Id = withdrawal.Id;
            this.amount = Withdrawal.amount;
            return this;
        }

        public Withdrawal build() {
            return new Withdrawal(this);
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
        Withdrawal withdrawal = (Withdrawal) obj;
        return withdrawal.equals(withdrawal.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

