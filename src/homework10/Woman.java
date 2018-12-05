package homework10;

public class Woman extends Human{
    public Woman(String name, String surname, int year, int IQ, String[][] scedule) {
        super(name, surname, year, IQ, scedule);
    }

    public Woman(String name, String surname) {
        super(name, surname);
    }
    void makeUp(){
        System.out.println("Как быстро бежит время, а я даже еще не накрасилась!");
}
    @Override
    void gridPet(Pet animal) {
        System.out.println("Привет, " + animal.getNickname() + "! Я рада тебя видеть!");
    }
}
