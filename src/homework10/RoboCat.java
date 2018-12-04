package homework10;

public class RoboCat extends Pet implements Foul{
    public RoboCat(String nickname){
        super(nickname);
    }
    public RoboCat( String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + getNickname() + ". Я соскучился!");
    }
    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
}
