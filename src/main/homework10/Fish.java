package homework10;

import java.util.Arrays;

public class Fish extends Pet{
    public Fish(String nickname){
        super(nickname);
    }
    public Fish(String nickname, int age,  String[] habits) {
        super(nickname, age, habits);
        super.setSpecies(Species.FISH);
    }

    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }
    @Override
    public String toString() {
        return Species.FISH+"{nickname= " +
                getNickname() + " , age= " + getAge() +  " , habits= " + Arrays.toString(getHabits()) + "}";
    }
}
