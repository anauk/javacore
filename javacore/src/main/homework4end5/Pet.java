package main.homework4end5;
/*В классе Pet создайте конструкторы:

        конструктор, описывающий вид животного и его кличку
        конструктор, описывающий все поля животного
        пустой конструктор*/
import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits ;
    public Pet(){

}
public Pet( String species, String nickname){
    this.species= species;
    this.nickname = nickname;
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
}
