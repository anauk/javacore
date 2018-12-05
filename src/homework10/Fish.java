package homework10;

import homework8.Species;

import java.util.Arrays;

public class Fish extends Pet{
    private Species species;
    public Fish(String nickname){
        super(nickname);
    }
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
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
