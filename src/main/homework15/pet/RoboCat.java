package homework15.pet;

import java.util.Set;

public class RoboCat extends Pet implements Foul {
    {
        setSpecies(Species.CAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

}
