package main.homework12.pet;

import java.util.Set;

public class Fish extends Pet {
    {
        setSpecies(Species.FISH);
    }
    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }

}
