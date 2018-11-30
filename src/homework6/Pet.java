package homework6;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits ;

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
}
