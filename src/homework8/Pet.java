package homework8;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    protected static final String staticPet;
    protected String fieldPet;
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits ;
    protected void finalize()throws Throwable{
        System.out.println("This object from class Pet will be delete!");
    }
    static {
        staticPet = "class Pet";
        System.out.println(staticPet);
    }
    {
        fieldPet = "Object from class Pet";
        System.out.println(fieldPet);
    }

    public Pet(Species species, String nickname, int a, int tL, String[] habits) {
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

    public Species getSpecies() {
        return species;
    }

    public String[] getHabits() {
        return habits;
    }

    @Override
    public String toString() {
        String canFly = (getSpecies().isCanFly())?"может летать":"не может летать";
        String hasFur = (getSpecies().isHasFur())?"есть шерсть":"нет шерсти";
        return getSpecies().getName()+", "+canFly+", "+getSpecies().getNumberOfLegs()+" лап, "+hasFur+"{nickname= "+
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
