package ATMtrans.domain.bankInfor;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Branch {

    private String Id, Name;

    private Branch() {
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    private Branch(Builder builder) {

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

        public Builder copy(Branch branch){
            this.Id = branch.Id;
            this.Name = branch.Name;
            return this;
        }

        public Branch build() {
            return new Branch(this);
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
        Branch branch = (Branch) obj;
        return branch.equals(branch.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);        }
    }


