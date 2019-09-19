package ATMtrans.domain.atmInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Electricity {

    private String Id, MeterNum;
    private static double Amount;

    private Electricity() {
    }

    public String getId() {
        return Id;
    }

    public String getMeterNum() {
        return MeterNum;
    }

    public static double getAmount() {
        return Amount;
    }

    private Electricity(Builder builder) {

        this.Id = builder.Id;
        this.MeterNum = builder.MeterNum;
        this.Amount = builder.Amount;
    }

    public static class Builder {
        private String Id, MeterNum;
        private double Amount;

        public Builder Id(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder MeterNum(String MeterNum) {
            this.MeterNum = MeterNum;
            return this;
        }

        public Builder Amount(double Amount) {
            this.Amount = Amount;
            return this;
        }
        public Builder copy(Electricity electricity){
            this.Id = electricity.Id;
            this.MeterNum = electricity.MeterNum;
            this.Amount = electricity.Amount;
            return this;
        }

        public Electricity build() {
            return new Electricity(this);
        }
    }
        @Override
        public String toString() {
            return "Builder{" +
                    "Id='" + Id + '\'' +
                    ", MeterNum='" + MeterNum + '\'' +
                    ", Amount=R" + Amount +
                    '}';
        }
        @Override
        public boolean equals(Object obj) {
            if(this ==obj)return true;
            if(obj == null|| getClass() !=obj.getClass()) return false;
            Electricity electricity = (Electricity) obj;
            return electricity.equals(electricity.Id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Amount);        }

    }