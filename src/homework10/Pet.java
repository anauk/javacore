package homework10;

import java.util.Arrays;
import java.util.Objects;

abstract class Pet {
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(String nickname){
        this.nickname=nickname;
    }
    public Pet(String nickname, int age, int trickLevel, String[] habits) {
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

    public String[] getHabits() {
        return habits;
    }

    void eat() {
        System.out.println("Я кушаю!");
    }

    public abstract void respond();

    @Override
    public String toString() {
        return "{nickname= " +
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
