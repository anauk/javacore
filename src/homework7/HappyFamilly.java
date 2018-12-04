package homework7;

import java.util.Arrays;

public class HappyFamilly {
    public static void main(String[] args) {
        System.out.println("Это кот!");
        Pet cat = new Pet("Cat", "Vaca", 1, 70, new String[]{"sleep, play"});
        System.out.println(cat);
        Human mother1 = new Human("Vera", "Petrova", 1966, 79, new String[][]{{"day, task"},{"day_2, task_2"}});
        System.out.println("Это мама Вера! - "+ mother1);
        Human father1 = new Human("Artem", "Petrov",1966, 79, new String[][]{{"day, task"},{"day_2, task_2"}});
        System.out.println("Это папа Артем! - "+father1);
        Family family1 = new Family(mother1, father1);
        Human boy = new Human("Kola", "Petrov");
        System.out.println("Вот мальчик Коля!");
        family1.addChild(boy);
        Human girl = new Human("Lera", "Petrova");
        System.out.println("Вот девочка Лера! "+ girl);
        Human[] children = {boy, girl};
        System.out.println("Они брат и сестра ");
        family1.addChild(girl);
        System.out.println("А вот они вместе с семьей "+family1);
        System.out.println("Дочь Лера выросла и ушла из семьи?! " + family1.deletMethodChild(girl));
        System.out.println("А куда ушел третий ребенок?! "+ family1.deletChild(2) + " Нет столько детей в этой семьи!");
        System.out.println("Ушли все дети! "+family1.deletChild(0));
        System.out.println(family1);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Вот другая семья!");
        Human mother2 = new Human("Nina", "Gylash");
        System.out.println("Это мама "+ mother2);
        Human father2 = new Human("Devid", "Duchovnuy");
        System.out.println("Это папа "+ father2);
        Family family2 = new Family(mother2, father2);
        System.out.println("Это их семья: "+family2);
        family2.deletChild(0);
    }
}
