package homework15;

import homework15.famelyDao.CollectionFamilyDao;
import homework15.famelyDao.FamilyController;
import homework15.famelyDao.FamilyDao;
import homework15.famelyDao.FamilyService;
import homework15.family.Family;
import homework15.family.Human;
import homework15.family.Man;
import homework15.family.Woman;
import homework15.pet.*;

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
        Human mother1 = new Woman("Vera", "Petrova", "01/02/1984", 79, scedule3);
        System.out.println("Это мама Вера! - " + mother1);

        Map<String, String> scedule = new HashMap<>();
        scedule.put(DayOfWeek.MONDAY.name(), "day_2, task_2");
        Human father1 = new Man("Artem", "Petrov", "15/03/1985", 79, scedule);
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
        Human mother3 = new Woman("Poza", "Kochetkova","15/02/1973", 91, scedule0);
        System.out.println("Это мама " + mother2);
        Map<String, String> scedule2 = new HashMap<>();
        scedule2.put(DayOfWeek.SATURDAY.name(), "day_2, task_2");
        Human father3 = new Man("Artur", "Pirogkov","02/05/1970", 82, scedule2);
        Family family3 = new Family(mother3, father3);
        Human child1 = family3.bornChild();
        Human child2 = family3.bornChild();
        System.out.println(child1+ " " +child2);

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        familyController.createNewFamily(mother3,father3);
        familyController.createNewFamily(mother2,father2);
        familyController.createNewFamily(mother1,father1);
        for(Family f:familyController.getAllFamilies()) {
            System.out.println("Вывод всех семей: "+ f);
        }
        System.out.println("Method displayAllFamilies: ");
        familyController.displayAllFamilies();
        System.out.println("Все семиьи с количеством человек больше 1(Void): ");
        familyController.getFamiliesBiggerThan(1);
        System.out.println("Все семиьи с количеством человек больше 1(List): "+familyController.getFamiliesBiggerThan1(1));
        System.out.println("Все семиьи с количеством человек меньше 3: "+familyController.getFamiliesLessThan(3));
        System.out.println("Семьи,где количество человек равное 2: "+familyController.countFamiliesWithMemberNumber(2));

        Woman woman = new Woman("Ani", "Greed");
        Man man = new Man("Arten", "Vlasov");
        familyController.createNewFamily(woman,man);

        familyController.bornChild(familyController.getFamilyById(0), "Arseni",null);

        Human child4 = new Man("Lolic", "Shmolic", "12/09/1981",91,new HashMap<>());
        familyController.adoptChild(familyController.getFamilyById(1), child4);
        System.out.println(familyController.getFamilyById(1));

        familyController.addPet(3, cat);
        System.out.println(familyController.getFamilyById(3));
        System.out.println(familyController.getFamilyById(0).getChildren());
        System.out.println(familyController.getFamilyById(0).getPet());

        Human child5 = new Man("Lolic", "Shmolic", "15/06/1983",91,new HashMap<>());
        Human child6 = new Man("Rita", "Shmolic", "14/03/2001",91,new HashMap<>());
        Human child7 = new Man("Misha", "Shmolic", "11/11/2004",91,new HashMap<>());
        Human child8 = new Man("Ola", "Shmolic", "28/01/1978",91,new HashMap<>());
        Human child9 = new Man("Feda", "Shmolic", "30/12/1979",91,new HashMap<>());


        familyController.deleteFamilyByIndex(0);

        System.out.println("Семья с индексом 0: "+familyController.getFamilyById(0));
        familyService.bornChild(familyService.getFamilyById(1), "Lolic","Rita");
        familyController.adoptChild(familyController.getFamilyById(2), child6);
        familyController.adoptChild(familyController.getFamilyById(1), child7);
        familyController.adoptChild(familyController.getFamilyById(2), child5);
        familyController.adoptChild(familyController.getFamilyById(2), child8);
        familyController.adoptChild(familyController.getFamilyById(2), child9);
        for(Human child:family3.getChildren()){
            System.out.println(child.getName()+": "+child.describeAge());
        }
        for(Family f:familyController.getAllFamilies()) {
            System.out.println("Вывод всех семей: "+ f);
        }

        System.out.println("Семья с индексом 2 и ее дети: "+familyController.getFamilyById(2).getChildren());

        familyController.deleteAllChildrenOlderThen1(35);
        System.out.println("Вывод всех семей после метода deleteAllChildrenOlderThen1: ");
        int count = 1;
        for(Family f:familyController.getAllFamilies()) {
            System.out.println((count++)+ " " +f);
        }
        familyController.deleteAllChildrenOlderThen(11);
        System.out.println("Вывод всех семей после метода deleteAllChildrenOlderThen: ");
        for(Family f:familyController.getAllFamilies()) {
            System.out.println(f);
        }

        System.out.println(familyController.getFamilyById(3));

        System.out.println(familyController.getPets(0));
        System.out.println(familyController.getPets(2));
        System.out.println(father1.describeAge());

        System.out.println(child7);

    }
}
