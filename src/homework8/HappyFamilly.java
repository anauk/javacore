package homework8;

import java.util.Arrays;

public class HappyFamilly {
    public static void main(String[] args) {
        Human mother0 = new Human("Vera", "Ravlik");
        Human father0 = new Human("Peta", "Ravlik");
        Family family0= new Family(mother0, father0);
        /*for (int i = 0; i < 10000; i++) {
            Human rt = new Human(i);
        }*/
        Pet cat = new Pet(Species.CAT, "Vaca", 1, 70, new String[]{"sleep, play"});
        System.out.println("Это кот! "+cat);
        Pet fish = new Pet(Species.FISH, "Molly", 1, 20, new String[]{"swim, eat"});
        System.out.println("Это рыбка! "+ fish);
        Human mother1 = new Human("Vera", "Petrova", 1966, 79, new String[][]{{DayOfWeek.MONDAY.name()},{"day_2, task_2"}});
        System.out.println("Это мама Вера! - "+ mother1);

        Human father1 = new Human("Artem", "Petrov",1966, 79, new String[][]{{"day, task"},{"day_2, task_2"}});
        System.out.println("Это папа Артем! - "+father1);
        Family family1 = new Family(mother1, father1);
        Human boy = new Human("Kola", "Petrov");
        System.out.println("Вот мальчик Коля!");
        family1.addChild(boy);
        Human girl = new Human("Lera", "Petrova");
        Human girl2 = new Human("Vera", "Petrova");
        System.out.println("Вот девочка Лера! "+ girl);
        Human[] children = {boy, girl, girl2};
        System.out.println("Они брат и сестра ");
        family1.addChild(girl);
        family1.addChild(girl2);
        System.out.println("А вот они вместе с семьей: "+family1);
        System.out.println("Кто-то издетей ушел из семьи?! "+family1.deletChild(0));
        System.out.println(family1);
        System.out.println("Дочь Лера выросла и ушла из семьи?! " + family1.deletMethodChild(girl));
        System.out.println("А куда ушел третий ребенок?! "+ family1.deletChild(2) + " Нет столько детей в этой семьи!");
        System.out.println(family1);
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
