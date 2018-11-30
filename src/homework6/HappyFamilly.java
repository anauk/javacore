package homework6;

import java.util.Arrays;

public class HappyFamilly {
    public static void main(String[] args) {
        Pet cat = new Pet("Cat", "Vaca", 1, 70, new String[]{"sleep, play"});
        System.out.println(cat.toString());
        Human mother1 = new Human("Vera", "Petrova", 1966, 79, new String[][]{{"day, task"},{"day_2, task_2"}});
        System.out.println(mother1);
        Human father1 = new Human("Artem", "Petrov",1966, 79, new String[][]{{"day, task"},{"day_2, task_2"}});
        Human boy = new Human("Kola", "Petrov");
        Human girl = new Human("Lera", "BLABLA");
        Human[] children = {boy, girl};
        Family family1 = new Family(mother1, father1);
        family1.addChild(boy);
        boy.setFamily(family1);
        girl.setFamily(family1);
        System.out.println(family1.toString());
        System.out.println(Arrays.toString(children));
    }
}
