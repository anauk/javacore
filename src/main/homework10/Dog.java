package homework10;


import java.util.Arrays;

public class Dog extends Pet implements Foul{
    public Dog(String nickname){
        super(nickname);
    }
    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
    }
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }
    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
    @Override
    public String toString() {
        return Species.DOG+"{nickname= " +
                getNickname() + " , age= " + getAge() + " , trickLevel= " +
                getTrickLevel() + " , habits= " + Arrays.toString(getHabits()) + "}";
    }
}
