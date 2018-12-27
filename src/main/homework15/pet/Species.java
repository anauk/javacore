package homework15.pet;

public enum Species {
    DOG("Пес", false, 4, true), CAT("Кошка", false, 4, true), FISH("Рыбки", false, 0, false), BIRD("Птички", true, 0, false), UNKNOWN("", false, 0, false);
    private String name;
    boolean canFly;
    int numberOfLegs;
    boolean hasFur;

    private Species(String name, boolean canFly, int numberOfLegs, boolean hasFur) {
        this.name = name;
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public String getName() {
        return name;
    }

    public boolean CanFly() {
        return canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean HasFur() {
        return hasFur;
    }
}
