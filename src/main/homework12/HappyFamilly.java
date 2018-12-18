package homework12;

import homework12.famelyDao.CollectionFamilyDao;
import homework12.famelyDao.FamilyDao;
import homework12.family.Family;
import homework12.family.Human;
import homework12.family.Man;
import homework12.family.Woman;
import homework12.pet.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyFamilly {
    public static void main(String[] args) {
        Set<String> habits = new HashSet<>();
        habits.add("play");
        habits.add("slep");

        Pet cat = new DomesticCat("Vaca", 1, 70, habits);
        ((DomesticCat) cat).foul();
        System.out.println("Это кот! " + cat);

        Set<String> habits1 = new HashSet<>();
        habits1.add("swem");
        habits1.add("eat");
        Pet fish = new Fish("Molly", 1,20, habits1);
        System.out.println(fish.getClass());
        System.out.println("Это рыбка! " + fish);
        fish.respond();
        fish.eat();

        System.out.println(Species.CAT.name());

        Map<String, String> scedule3 = new HashMap<>();
        scedule3.put(DayOfWeek.FRIDAY.name(), "day_4, task_4");
        Human mother1 = new Woman("Vera", "Petrova", 1966, 79, scedule3);
        System.out.println("Это мама Вера! - " + mother1);

        Map<String, String> scedule = new HashMap<>();
        scedule.put(DayOfWeek.MONDAY.name(), "day_2, task_2");
        Human father1 = new Man("Artem", "Petrov", 1966, 79, scedule);
        System.out.println("Это папа Артем! - " + father1);
        mother1.gridPet();
        father1.gridPet();

        Family family1 = new Family(mother1, father1);
        Pet robot = new RoboCat("Meral", 2, 99, habits);
        family1.addPet(robot);

        Human boy = new Man("Kola", "Petrov");
        System.out.println("Вот мальчик Коля!");
        family1.addChild(boy);
        System.out.println(family1.countFamily());

        Human girl = new Woman("Lera", "Petrova");
        Human girl2 = new Woman("Vera", "Petrova");
        System.out.println("Вот девочка Лера! " + girl);

        System.out.println("Они брат и сестры ");
        family1.addChild(girl);
        family1.addChild(girl2);
        System.out.println(family1.countFamily());
        System.out.println("А вот они вместе с семьей: " + family1);
        System.out.println("Кто-то издетей ушел из семьи?! " + family1.deletChild(0));
        System.out.println(family1);
        System.out.println("Дочь Лера выросла и ушла из семьи?! " + family1.deletChild(girl));
        System.out.println("А куда ушел третий ребенок?! " + family1.deletChild(2) + " Нет столько детей в этой семьи!");
        System.out.println(family1);
        System.out.println("Ушли все дети! " + family1.deletChild(0));
        System.out.println(family1);
        System.out.println(family1.countFamily());
        System.out.println(family1.bornChild());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Вот другая семья!");
        Human mother2 = new Woman("Nina", "Gylash");
        System.out.println("Это мама " + mother2);
        Human father2 = new Man("Devid", "Duchovnuy");
        System.out.println("Это папа " + father2);
        Family family2 = new Family(mother2, father2);
        System.out.println("Это их семья: " + family2);
        family2.deletChild(0);
        ((Woman) mother2).makeUp();
        ((Man) father2).repairCar();
        System.out.println(family2.countFamily());
        System.out.println(family2.bornChild());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Вот третья семья!");
        Map<String, String> scedule0 = new HashMap<>();
        scedule0.put(DayOfWeek.WEDNESDAY.name(), "day_3, task_3");
        Human mother3 = new Woman("Poza", "Kochetkova",1966, 91, scedule0);
        System.out.println("Это мама " + mother2);
        Map<String, String> scedule2 = new HashMap<>();
        scedule2.put(DayOfWeek.SATURDAY.name(), "day_2, task_2");
        Human father3 = new Man("Artur", "Pirogkov",1956, 82, scedule2);
        Family family3 = new Family(mother3, father3);
        Human child1 = family3.bornChild();
        Human child2 = family3.bornChild();
        System.out.println(child1+ " " +child2);

        FamilyDao familyDao = new CollectionFamilyDao();
        Human mother4 = new Woman("Vera","Pet");
        Human father4 = new Man("Peta","Pet");
        Family family4 = new Family(mother4, father4);
        familyDao.saveFamily(family4);
        System.out.println(familyDao.getAllFamilies());
        Human mother5 = new Woman("Olga","Qwerty");
        Human father5 = new Man("Vlad","Qwerty");
        Family family5 = new Family(mother5, father5);
        familyDao.saveFamily(family5);
        familyDao.saveFamily(family1);
        familyDao.saveFamily(family2);
        for (Family family:familyDao.getAllFamilies()) {
            System.out.println("family dao: "+family);
        }
        System.out.println("Family under index 0 = "+ familyDao.getFamilyByIndex(0));
        System.out.println("Family under index 1 = "+ familyDao.getFamilyByIndex(1));
        System.out.println(familyDao.deleteFamily(1));
        System.out.println(familyDao.deleteFamily(family1));
        System.out.println(familyDao.getAllFamilies());
        System.out.println(familyDao.deleteFamily(1));
        System.out.println(familyDao.getAllFamilies());
        System.out.println(familyDao.deleteFamily(0));
        System.out.println(familyDao.deleteFamily(0));

        for (Family family:familyDao.getAllFamilies()) {
            System.out.println("family dao: "+family);
        }

    }
}
