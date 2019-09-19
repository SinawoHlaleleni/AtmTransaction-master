package ATMtrans.domain.account;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Statement {

    private static String id;
    private static String type;

    private Statement (){}

    private Statement(Builder builder){

        this.id= builder.id;
        this.type=builder.type;
    }

    public static String getId() {
        return id;
    }

    public static String getType() {
        return type;
    }

    public static class Builder {
        private String id, type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.id = id;
            return this;
        }

        public Builder copy(Statement statement){
            this.id = statement.id;
            this.type = statement.type;
            return this;
        }

        public Statement build() {
            return new Statement(this);
        }
    }
        @Override
        public String toString() {
            return "Builder{" +
                    "id='" + id + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(this ==obj)return true;
            if(obj == null|| getClass() !=obj.getClass()) return false;
            Statement statement = (Statement) obj;
            return statement.equals(statement.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }
