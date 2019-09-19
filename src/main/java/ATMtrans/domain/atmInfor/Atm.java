package ATMtrans.domain.atmInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Atm {

    private String Id;
    private static String Type;


    private Atm() {
    }

    public String getId() {
        return Id;
    }

    public static String getType() {
        return Type;
    }

    private Atm(Builder builder) {

        this.Id = builder.Id;
        this.Type = builder.Type;

    }

    public static class Builder {
        private String Id, Type;

        public Builder Id(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder Type(String Type) {
            this.Type = Type;
            return this;
        }
        public Builder copy(Atm atm){
            this.Id = atm.Id;
            this.Type = atm.Type;
            return this;
        }

        public Atm build() {
            return new Atm(this);
        }

    }
        @Override
        public String toString() {
            return "Builder{" +
                    "Id='" + Id + '\'' +
                    ", Type='" + Type + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(this ==obj)return true;
            if(obj == null|| getClass() !=obj.getClass()) return false;
            Atm atm = (Atm) obj;
            return atm.equals(atm.Id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Type);        }
    }
