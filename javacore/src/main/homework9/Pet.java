package main.homework9;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public Species getSpecies() {
        return species;
    }

    public String[] getHabits() {
        return habits;
    }

    void eat() {
        System.out.println("Я кушаю!");
    }

    void respond() {
        System.out.println("Привет, хозяин. Я - " + nickname + ". Я соскучился!");
    }

    void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    @Override
    public String toString() {
        String canFly = (getSpecies().CanFly()) ? "может летать" : "не может летать";
        String hasFur = (getSpecies().HasFur()) ? "есть шерсть" : "нет шерсти";
        return getSpecies().getName() + ", " + canFly + ", " + getSpecies().getNumberOfLegs() + " лап, " + hasFur + "{nickname= " +
                getNickname() + " , age= " + getAge() + " , trickLevel= " +
                getTrickLevel() + " , habits= " + Arrays.toString(getHabits()) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return this.age == pet.age &&
                this.nickname.equals(pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, age);
    }

    protected void finalize() {
        System.out.println("This object from class Pet will be delete!");
    }

    static {
        System.out.println("class Pet");
    }

    {
        System.out.println("Object from class Pet");
    }
}
