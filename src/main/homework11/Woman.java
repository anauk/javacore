package homework11;

import java.util.Map;

public class Woman extends Human {
    public Woman(String name, String surname, int year, int IQ, Map<String, String> scedule) {
        super(name, surname, year, IQ, scedule);
    }

    public int getIq() {
        return IQ;
    }

    public Woman(String name, String surname) {
        super(name, surname);
    }

    void makeUp() {
        System.out.println("Как быстро бежит время, а я даже еще не накрасилась!");
    }

    @Override
    void gridPet(Pet animal) {
        System.out.println("Привет, " + animal.getNickname() + "! Я рада тебя видеть!");
    }
}
