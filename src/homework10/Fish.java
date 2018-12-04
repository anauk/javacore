package homework10;

import homework8.Species;

public class Fish extends Pet{
    public Fish(String nickname){
        super(nickname);
    }
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }
}
