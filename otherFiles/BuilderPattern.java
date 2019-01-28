public class BuilderPattern {
    public static void main(String[] args) {
        UsingBP h = new UsingBP.Builder()
                .setId(1)
                .setPhone(8067)
                .setSomeNumb1(100)
                .setSomeNumb2(200)
                .setSomeNumb3(400)
                .build();

        System.out.println("id : " + h.getId() + " " + "phone : "
                + h.getPhone() + " " + "someNumbers from 1 to 3: "
                + h.getSomeNumb1() +  " " +  h.getSomeNumb2() + " "
                + h.getSomeNumb3());
        System.out.println();
    }
}

class UsingBP {
    private final int id;      // can be non-final
    private final int phone;
    private final int someNumb1;
    private final int someNumb2;
    private final int someNumb3;

    public static class Builder {
        private int id1;
        private int phone1;
        private int someNumb1;
        private int someNumb2;
        private int someNumb3;
        public Builder setId (int i) {
            id1 = i;
            return this;
        }
        public Builder setPhone (int i) {
            phone1 = i;
            return this;
        }
        public Builder setSomeNumb1 (int i) {
            someNumb1 = i;
            return this;
        }
        public Builder setSomeNumb2 (int i) {
            someNumb2 = i;
            return this;
        }
        public Builder setSomeNumb3 (int i) {
            someNumb3 = i;
            return this;
        }
        public UsingBP build () {
            return new UsingBP(this);
        }
    }

    private UsingBP(Builder builder) {
        id = builder.id1;
        phone = builder.phone1;
        someNumb1 = builder.someNumb1;
        someNumb2 = builder.someNumb2;
        someNumb3 = builder.someNumb3;
    }

    public int getId() {
        return id;
    }
    public int getPhone() {
        return phone;
    }
    public int getSomeNumb1() {
        return someNumb1;
    }
    public int getSomeNumb3() {
        return someNumb3;
    }
    public int getSomeNumb2() {
        return someNumb2;
    }
}
