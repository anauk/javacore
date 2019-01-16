package homework17;

import homework17.famelyDao.CollectionFamilyDao;
import homework17.famelyDao.FamilyController;
import homework17.famelyDao.FamilyDao;
import homework17.famelyDao.FamilyService;
import homework17.family.Human;
import homework17.family.Man;
import homework17.family.Woman;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static homework17.family.Human.SDF;

public class ConsoleApp {
    static{
        SDF.setLenient(true);
    }
    public void consoleMethod(){
        Map<String, String> scedule3 = new HashMap<>();
        scedule3.put(DayOfWeek.FRIDAY.name(), "day_4, task_4");
        Human mother1 = new Woman("Vera", "Petrova", "01/02/1984", 79, scedule3);
        Human father1 = new Man("Andrey", "Petrov", "01/02/1981", 89, scedule3);
        Human mother2 = new Woman("Ola", "Simpson", "01/02/1979", 69, scedule3);
        Human father2 = new Man("Arseniy", "Simpson", "01/02/1975", 71, scedule3);
        Human mother3 = new Woman("Rita", "Sicolova", "01/02/1960", 77, scedule3);
        Human father3 = new Man("Roma", "Socolov", "01/02/1955", 73, scedule3);

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
                            boolean genderMorW = gender.toLowerCase().trim().equals("female");
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
                    while(!checkInputNumber(number)){
                        number = s.nextLine();
                    }
                    familyController.deleteAllChildrenOlderThen(Integer.parseInt(number));
                    continue outerLoop;
                case "10":
                    break outerLoop;
                default:
                    System.out.println("Что-то пошло не так!");
            }
        }
    }
    private static boolean checkInputNumber(String number) {
        try {
            int age = Integer.parseInt(number);
            if(age > 0 && age <20)
            return true;
        } catch (NumberFormatException e) {
            System.out.println("It is not a number! Try again.");
            return false;
        }
        System.out.println("Try check number from 1 to 19");
        return false;
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

        while(!isDayOfBerthday(dateOfBerth)){
            String year1 = scanner.nextLine();
            String month2 = scanner.nextLine();
            String day3 = scanner.nextLine();
        }
        Human human = gender ? new Woman(name, surname, dateOfBerth, Integer.parseInt(iq)) : new Man(name, surname, dateOfBerth, Integer.parseInt(iq));
        return human;
    }

    private static boolean isDayOfBerthday(String dateOfBerth) {
        try {
            SDF.format((SDF.parse(dateOfBerth).equals(dateOfBerth)));
            return true;
        } catch (ParseException ex) {
            return false;
        }
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
