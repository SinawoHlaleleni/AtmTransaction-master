package ATMtrans.domain.account;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Flexible {

    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }


    public double getAmount() {
        return amount;
    }


    private Flexible(){}

    private Flexible (Builder builder){

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
        public Builder copy(Flexible flexible){
            this.Id = flexible.Id;
            this.amount = Flexible.amount;
            return this;
        }

        public Flexible build() {
            return new Flexible(this);
        }
    }
    @Override
    public String toString() {
        return "Builder{" +
                "Id='" + Id + '\'' +
                ", Amount='" + amount + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        Flexible flexible = (Flexible) obj;
        return flexible.equals(flexible.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

