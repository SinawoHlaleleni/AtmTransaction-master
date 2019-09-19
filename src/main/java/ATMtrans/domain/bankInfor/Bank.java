package ATMtrans.domain.bankInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Bank {

    private String Id, Name;

    public Bank() {
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    private Bank(Builder builder) {

        this.Id = builder.Id;
        this.Name = builder.Name;

    }

    public static class Builder {
        private String Id, Name;

        public Builder Id(String Id) {
            this.Id = Id;
            return this;
        }

        public Builder Name(String Name) {
            this.Name = Name;
            return this;
        }
        public Builder copy(Bank bank){
            this.Id = bank.Id;
            this.Name = bank.Name;
            return this;
        }

        public Bank build() {
            return new Bank(this);
        }
    }
        @Override
        public String toString() {
            return "Builder{" +
                    "Id='" + Id + '\'' +
                    ", Name='" + Name + '\'' +
                    '}';
        }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        Bank bank = (Bank) obj;
        return bank.equals(bank.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);        }

    }
