package homework16;

import homework16.famelyDao.CollectionFamilyDao;
import homework16.famelyDao.FamilyController;
import homework16.famelyDao.FamilyDao;
import homework16.famelyDao.FamilyService;
import homework16.family.Family;
import homework16.family.Human;
import homework16.family.Man;
import homework16.family.Woman;
import homework16.pet.*;

import java.io.IOException;
import java.util.*;

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
        Pet fish = new Fish("Molly", 1, 20, habits1);
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
        Human mother3 = new Woman("Poza", "Kochetkova", "15/02/1973", 91, scedule0);
        System.out.println("Это мама " + mother2);
        Map<String, String> scedule2 = new HashMap<>();
        scedule2.put(DayOfWeek.SATURDAY.name(), "day_2, task_2");
        Human father3 = new Man("Artur", "Pirogkov", "02/05/1970", 82, scedule2);
        Family family3 = new Family(mother3, father3);
        Human child1 = family3.bornChild();
        Human child2 = family3.bornChild();
        System.out.println(child1 + " " + child2);

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        outerLoop:
        while (true) {
            Scanner s = new Scanner(System.in);
            displayChoiceList();
            String number;
            String choice = s.nextLine();
            switch (choice) {
                case "1":
                    familyController.createNewFamily(mother1, father1);
                    familyController.createNewFamily(mother2, father2);
                    familyController.createNewFamily(mother3, father3);
                    continue outerLoop;
                case "2":
                    familyController.displayAllFamilies();
                    continue outerLoop;
                case "3":
                    System.out.println("Укажите количество людей в семье:");
                    number = s.nextLine();
                    familyController.getFamiliesBiggerThan(Integer.parseInt(number));
                    continue outerLoop;
                case "4":
                    System.out.println("Укажите количество людей в семье:");
                    number = s.nextLine();
                    familyController.getFamiliesLessThan(Integer.parseInt(number));
                    continue outerLoop;
                case "5":
                    System.out.println("Укажите количество людей в семье:");
                    number = s.nextLine();
                    System.out.println("Количество семей, где количество людей "+number+" = "+familyController.countFamiliesWithMemberNumber(Integer.parseInt(number)));
                    continue outerLoop;
                case "6":
                    familyController.createNewFamily(createHuman(true, false), createHuman(false, false));
                    continue outerLoop;
                case "7":
                    System.out.println("Укажите порядковый номер семьи: ");
                    number = s.nextLine();
                    familyController.deleteFamilyByIndex(Integer.parseInt(number) - 1);
                    System.out.println("Семья под номером "+number+ " удалена.");
                    continue outerLoop;
                case "8":
                    displayEditFamily();
                    String chooze = s.nextLine();
                    switch (chooze) {
                        case "1":
                            System.out.println("порядковый номер семьи?");
                            number = s.nextLine();

                            System.out.println("какое имя дать мальчику?");
                            String boyName = s.nextLine();

                            System.out.println("какое имя дать девочке?");
                            String girlName = s.nextLine();

                            familyController.bornChild(familyController.getFamilyById(Integer.parseInt(number) - 1), boyName, girlName);
                            System.out.println("Поздравляем, у вас родился ребенок!");
                            System.out.println(familyController.getFamilyById(Integer.parseInt(number)-1));
                            continue outerLoop;
                        case "2":
                            System.out.println("порядковый номер семьи?");
                            number = s.nextLine();
                            System.out.println("Введите пол ребенка: male-мужской, female-женский");
                            String gender = s.nextLine();
                            boolean genderMorW = gender.toLowerCase().trim().equals("female")?true:false;
                            familyController.adoptChild(familyController.getFamilyById(Integer.parseInt(number) - 1), createHuman(genderMorW,true));
                            continue outerLoop;
                        case "3":
                            continue outerLoop;
                        default:
                            System.out.println("Ошибка ввода!");
                            continue outerLoop;

                    }
                case "9":
                    System.out.println("Укажите возраст ребенка, чтобы удалить его из семьи");
                    number = s.nextLine();
                    familyController.deleteAllChildrenOlderThen(Integer.parseInt(number));
                    continue outerLoop;
                case "10":
                    break outerLoop;
                default:
                    System.out.println("Что-то пошло не так!");
            }
        }
    }

    private static Human createHuman(boolean gender, boolean child) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(!child ? gender ? "Введите имя матери!" : "Введите имя отца!" : "Ввведите имя ребенка");
        System.out.println(!child ? gender ? "Введите фамилию матери!" : "Введите фамилию отца!" : "Ввведите фамилию ребенка");
        System.out.println(!child ? gender ? "Введите год рождения матери!(гггг)" : "Введите год рождения  отца!(гггг)" : "Ввведите год рождения  ребенка (гггг)");
        System.out.println(!child ? gender ? "Введите месяц рождения матери!(мм)" : "Введите месяц рождения отца!(мм)" : "Ввведите месяц рождения  ребенка (мм)");
        System.out.println(!child ? gender ? "Введите день рождения матери!(дд)" : "Введите день рождения отца!(дд)" : "Ввведите день рождения  ребенка (дд)");
        System.out.println(!child ? gender ? "Введите iq матери!" : "Введите iq отца!" : "Ввведите iq ребенка ");

        String name = scanner.nextLine();
        String surname = scanner.nextLine();
        String year = scanner.nextLine();
        String month = scanner.nextLine();
        String day = scanner.nextLine();
        String iq = scanner.nextLine();

        String dateOfBerth = day+"/"+month+"/"+year;
        Human human = gender ? new Woman(name, surname, dateOfBerth, Integer.parseInt(iq)) : new Man(name, surname, dateOfBerth, Integer.parseInt(iq));
        return human;
    }

    private static void displayChoiceList() {
        String[] choices = new String[]{"Заполнить тестовыми данными.", "Отобразить весь список семей",
                "Отобразить список семей, где количество людей больше заданного", "Отобразить список семей, где количество людей меньше заданного",
                "Подсчитать количество семей, где количество членов равно", "Создать новую семью",
                "Удалить семью по индексу семьи в общем списке", "Редактировать семью по индексу семьи в общем списке",
                "Удалить всех детей старше возраста...", "Exit"};
        int id = 0;
        for (String choice : choices) {
            System.out.println((id + 1) + ". " + choice);
            ++id;
        }
    }

    private static void displayEditFamily() {
        String[] choices = new String[]{"Родить ребенка", "Усыновить ребенка",
                "Вернуться в главное меню"};
        int id = 0;
        for (String choice : choices) {
            System.out.println((id + 1) + ". " + choice);
            ++id;
        }
    }
}
