package lecture16;

public class Pizza {
    private final int dough;
    private int meat;
    private int tomato;
    private int cheese;

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", meat=" + meat +
                ", tomato=" + tomato +
                ", cheese=" + cheese +
                '}';
    }

    public static class Builder {
        private final int dough;
        private int cheese = 0;
        private int meat = 0;
        private int tomato = 0;

       public Builder(int dough) {
            this.dough = dough;
        }

       public  Builder cheese(int val) {
            cheese = val;
            return this;
        }

        public   Builder meat(int val) {
            meat = val;
            return this;
        }

        public  Builder tomato(int val) {
            tomato = val;
            return this;
        }

        public    Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        dough = builder.dough;
        meat = builder.meat;
        tomato = builder.tomato;
        cheese = builder.cheese;
    }

    public static void main(String[] args) {
        Pizza pizza1=new Builder(200)
                .cheese(100)
                .tomato(100)
                .build();
        System.out.println(pizza1);
        Pizza pizza2=new Builder(300)
                .cheese(200)
                .tomato(100)
                .meat(300)
                .build();
        System.out.println(pizza2);
    }
}