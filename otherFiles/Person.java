public final class Person {
    private final int id;
    private final int phone;
    private final int additionalPhone;
    private final int officeNum;
    private final int luckyNum;

    private Person(Builder builder) {
        id = builder.id;
        phone = builder.phone;
        additionalPhone = builder.additionalPhone;
        officeNum = builder.officeNum;
        luckyNum = builder.luckyNum;
    }

    public static class Builder {
        private int id;
        private int phone;
        private int additionalPhone;
        private int officeNum;
        private int luckyNum;
        public Builder setId (int i) {
            id = i;
            return this;
        }
        public Builder setPhone (int i) {
            phone = i;
            return this;
        }
        public Builder setAdditionalPhone(int i) {
            additionalPhone = i;
            return this;
        }
        public Builder setOfficeNum(int i) {
            officeNum = i;
            return this;
        }
        public Builder setLuckyNum(int i) {
            luckyNum = i;
            return this;
        }
        public Person build () {
            return new Person(this);
        }
    }

    public int getId() {
        return id;
    }
    public int getPhone() {
        return phone;
    }
    public int getAdditionalPhone() {
        return additionalPhone;
    }
    public int getLuckyNum() {
        return luckyNum;
    }
    public int getOfficeNum() {
        return officeNum;
    }
}
