package ATMtrans.domain.cardless;

import java.util.Objects;

public class Ewallet {

    private String Id, num;
    private double Amount;

    private Ewallet (){}

    public String getId() {
        return Id;
    }

    public String getNum() {
        return num;
    }

    public double getAmount() {
        return Amount;
    }

    private Ewallet(Builder builder){

        this.Id= builder.Id;
        this.num=builder.num;
        this.Amount=builder.Amount;
    }

    public static class Builder {
        private String Id, num;
        private double Amount;

        public Builder Id(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder num(String num) {
            this.num = num;
            return this;
        }

        public Builder Amount(double Amount) {
            this.Amount = Amount;
            return this;
        }

        public Builder copy(Ewallet ewallet){
            this.Id = ewallet.Id;
            this.num = ewallet.num;
            this.Amount = ewallet.Amount;
            return this;
        }

        public Ewallet build() {
            return new Ewallet(this);
        }
    }
        @Override
        public String toString() {
            return "Builder{" +
                    "Id='" + Id + '\'' +
                    ", num='" + num + '\'' +
                    ", Amount=R" + Amount +
                    '}';

    }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        Ewallet ewallet = (Ewallet) obj;
        return ewallet.equals(ewallet.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);        }
}
