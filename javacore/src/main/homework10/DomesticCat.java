package main.homework10;

import java.util.Arrays;

public class DomesticCat extends Pet implements Foul {
    {
        setSpecies(Species.CAT);
    }
    public DomesticCat(String nickname) {
        super(nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
}
