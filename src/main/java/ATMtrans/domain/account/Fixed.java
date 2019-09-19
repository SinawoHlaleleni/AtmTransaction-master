package ATMtrans.domain.account;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Fixed implements Account{

    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }

    @Override
    public double getAmount() {
        return amount;
    }


    private Fixed(){}

    private Fixed (Builder builder){

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
        public Builder copy(Fixed fixed){
            this.Id = fixed.Id;
            this.amount = Fixed.amount;
            return this;
        }

        public Fixed build() {
            return new Fixed(this);
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
        Fixed fixed = (Fixed) obj;
        return fixed.equals(fixed.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

