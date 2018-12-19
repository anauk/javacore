package homework13.pet;

import java.util.Objects;
import java.util.Set;

public abstract class Pet{
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;
    private Species species = Species.UNKNOWN;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.habits = habits;
    }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void setSpecies(Species species) {
        this.species = species;
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

    public Set<String> getHabits() {
        return habits;
    }

    public void eat() {
        System.out.println("Я кушаю!");
    }

    public abstract void respond();

    @Override
    public String toString() {
        return species + "{nickname= " +
                getNickname() + " , age= " + getAge() + " , trickLevel= " +
                getTrickLevel() + " , habits= " + getHabits() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return this.age == pet.age &&
                this.nickname.equals(pet.nickname) &&
                this.species.equals(pet.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, age, species);
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
