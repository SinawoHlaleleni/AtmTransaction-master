package ATMtrans.domain.cardless;

import ATMtrans.domain.atmTransies.Withdrawal;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class CardlessWithdrawal {

    private String Id;
    private static double amount =0;

    public String getId() {
        return Id;
    }

    public double getAmount() {
        return amount;
    }


    private CardlessWithdrawal(){}

    private CardlessWithdrawal (Builder builder){

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
        public Builder copy(CardlessWithdrawal cardlessWithdrawal){
            this.Id = cardlessWithdrawal.Id;
            this.amount = CardlessWithdrawal.amount;
            return this;
        }

        public CardlessWithdrawal build() {
            return new CardlessWithdrawal(this);
        }
    }
    @Override
    public String toString() {
        return "Builder{" +
                "Id='" + Id + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(this ==obj)return true;
        if(obj == null|| getClass() !=obj.getClass()) return false;
        CardlessWithdrawal cardlessWithdrawal = (CardlessWithdrawal) obj;
        return cardlessWithdrawal.equals(cardlessWithdrawal.Id);        }

    @Override
    public int hashCode() {
        return Objects.hash(amount);        }
}

