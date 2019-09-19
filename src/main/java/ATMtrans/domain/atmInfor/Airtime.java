package ATMtrans.domain.atmInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan

public class Airtime {

    private String tId, tType;
    private static double tAmount;

    private Airtime (){}

    public String gettId() {
        return tId;
    }

    public String gettType() {
        return tType;
    }

    public static double gettAmount() {
        return tAmount;
    }

    private Airtime(Builder builder){

        this.tId= builder.tId;
        this.tType=builder.tType;
        this.tAmount=builder.tAmount;
    }

    public static class Builder {
        private String tId, tType;
        private double tAmount;

        public Builder tId(String tId) {
            this.tId = tId;
            return this;
        }

        public Builder tType(String tType) {
            this.tType = tType;
            return this;
        }

        public Builder tAmount(double tAmount) {
            this.tAmount = tAmount;
            return this;
        }

        public Builder copy(Airtime airtime){
            this.tId = airtime.tId;
            this.tType = airtime.tType;
            this.tAmount = airtime.tAmount;
            return this;
        }

        public Airtime build() {
            return new Airtime(this);
        }
    }
        @Override
        public String toString() {
            return "Builder{" +
                    "tId='" + tId + '\'' +
                    ", tType='" + tType + '\'' +
                    ", tAmount=R" + tAmount +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(this ==obj)return true;
            if(obj == null|| getClass() !=obj.getClass()) return false;
            Airtime airtime = (Airtime) obj;
            return airtime.equals(((Airtime) obj).gettAmount());
        }

        @Override
        public int hashCode() {
            return Objects.hash(tAmount);        }

    }

