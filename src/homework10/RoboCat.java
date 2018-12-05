package homework10;

import java.util.Arrays;

public class RoboCat extends Pet implements Foul{
    private Species species;
    public RoboCat(String nickname){
        super(nickname);
    }
    public RoboCat( String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.CAT;
    }
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }
    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
    @Override
    public String toString() {
        return Species.CAT+"{nickname= " +
                getNickname() + " , age= " + getAge() + " , trickLevel= " +
                getTrickLevel() + " , habits= " + Arrays.toString(getHabits()) + "}";
    }
}
