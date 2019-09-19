package ATMtrans.domain.atmInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Topup {

    private String Id;
    private static String Type;


    private Topup (){}

    public String getId() {
        return Id;
    }

    public static String getType() {
        return Type;
    }

    private Topup (Builder builder){

        this.Id= builder.Id;
        this.Type=builder.Type;

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
        public Builder copy(Topup topup){
            this.Id = topup.Id;
            this.Type = topup.Type;
            return this;
        }

        public Topup build() {
            return new Topup(this);
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
            Topup topup = (Topup) obj;
            return topup.equals(topup.Id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Type);        }

    }

