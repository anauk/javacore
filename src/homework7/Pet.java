package homework7;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    protected static final String staticPet;
    protected String fieldPet;
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits ;
    static {
        staticPet = "class Pet";
        System.out.println(staticPet);
    }
    {
        fieldPet = "Object from class Pet";
        System.out.println(false);
    }

    public Pet(String species, String nickname, int a, int tL, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = a;
        this.trickLevel = tL;
        this.habits = habits;
    }

    void eat(){
        System.out.println("Я кушаю!");
    }
    void respond(){
        System.out.println("Привет, хозяин. Я - "+ nickname + ". Я соскучился!");
    }
    void foul(){
        System.out.println("Нужно хорошо замести следы...");
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

    public String getSpecies() {
        return species;
    }

    public String[] getHabits() {
        return habits;
    }

    @Override
    public String toString() {
        return getSpecies()+"{nickname= "+
                getNickname()+" , age= " + getAge()+" , trickLevel= "+
                getTrickLevel()+" , habits= " + Arrays.toString(getHabits()) +"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return this.age == pet.age&&
                Objects.equals(fieldPet, pet.fieldPet) &&
                Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldPet);
    }
}
