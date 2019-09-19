package ATMtrans.domain.atmInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class CashLimit {

    private String Id ;
    private static double Amount;

    private CashLimit (){}

    public String getId() {
        return Id;
    }

    public static double getAmount() {
        return Amount;
    }

    private CashLimit(Builder builder){

        this.Id= builder.Id;
        this.Amount=builder.Amount;
    }

    public static class Builder {
        private String Id;
        private double Amount;

        public Builder Id(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder Amount(double Amount) {
            this.Amount = Amount;
            return this;
        }

        public Builder copy(CashLimit cashLimit){
            this.Id = cashLimit.Id;
            this.Amount = cashLimit.Amount;
            return this;
        }

        public CashLimit build() {
            return new CashLimit(this);
        }
    }
        @Override
        public String toString() {
            return "Builder{" +
                    "Id='" + Id + '\'' +
                    ", Amount=R " + Amount +
                    '}';
        }
        @Override
        public boolean equals(Object obj) {
            if(this ==obj)return true;
            if(obj == null|| getClass() !=obj.getClass()) return false;
            CashLimit cashLimit = (CashLimit) obj;
            return cashLimit.equals(cashLimit.Id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Amount);        }

    }
