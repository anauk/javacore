package homework17;

import homework17.famelyDao.CollectionFamilyDao;
import homework17.famelyDao.FamilyController;
import homework17.famelyDao.FamilyDao;
import homework17.famelyDao.FamilyService;
import homework17.family.Human;
import homework17.family.Man;
import homework17.family.Woman;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static homework17.family.Human.SDF;

public class ConsoleApp {
    public Scanner scanner = new Scanner(System.in);
    static {
        SDF.setLenient(true);
    }
    private String[] choices1 = {"Заполнить тестовыми данными.", "Отобразить весь список семей",
            "Отобразить список семей, где количество людей больше заданного", "Отобразить список семей, где количество людей меньше заданного",
            "Подсчитать количество семей, где количество членов равно", "Создать новую семью",
            "Удалить семью по индексу семьи в общем списке", "Редактировать семью по индексу семьи в общем списке",
            "Удалить всех детей старше возраста...", "Exit"};
    private String[] choices2 = {"Родить ребенка", "Усыновить ребенка",
            "Вернуться в главное меню"};
    private FamilyDao familyDao = new CollectionFamilyDao();
    private FamilyService familyService = new FamilyService(familyDao);
    private FamilyController familyController = new FamilyController(familyService);

    public void consoleMethod() {
        Map<String, String> scedule3 = new HashMap<>();
        scedule3.put(DayOfWeek.FRIDAY.name(), "day_4, task_4");
        Human mother1 = new Woman("Vera", "Petrova", "01/02/1984", 79, scedule3);
        Human father1 = new Man("Andrey", "Petrov", "01/02/1981", 89, scedule3);
        Human mother2 = new Woman("Ola", "Simpson", "01/02/1979", 69, scedule3);
        Human father2 = new Man("Arseniy", "Simpson", "01/02/1975", 71, scedule3);
        Human mother3 = new Woman("Rita", "Sicolova", "01/02/1960", 77, scedule3);
        Human father3 = new Man("Roma", "Socolov", "01/02/1955", 73, scedule3);

        outerLoop:
        while (true) {
            displayChoiceList(choices1);
            String number;
            String choice = scanner.nextLine();
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
                    number = askPrintAnsver("Укажите количество людей в семье:");
                    familyController.getFamiliesBiggerThan(Integer.parseInt(number));
                    continue outerLoop;
                case "4":
                    number = askPrintAnsver("Укажите количество людей в семье:");
                    familyController.getFamiliesLessThan(Integer.parseInt(number));
                    continue outerLoop;
                case "5":
                    number = askPrintAnsver("Укажите количество людей в семье:");
                    System.out.println("Количество семей, где количество людей " + number + " = " + familyController.countFamiliesWithMemberNumber(Integer.parseInt(number)));
                    continue outerLoop;
                case "6":
                    familyController.createNewFamily(createHuman(true, false), createHuman(false, false));
                    continue outerLoop;
                case "7":
                    number = askPrintAnsver("Укажите порядковый номер семьи: ");
                    number = getString(number, checkInputIndex(number));
                    familyController.deleteFamilyByIndex(Integer.parseInt(number) - 1);
                    continue outerLoop;
                case "8":
                    displayChoiceList(choices2);
                    String chooze = scanner.nextLine();
                    switch (chooze) {
                        case "1":
                            number = askPrintAnsver("порядковый номер семьи?");
                            number = getString(number, checkInputIndex(number));
                            String boyName = askPrintAnsver("какое имя дать мальчику?");
                            String girlName = askPrintAnsver("какое имя дать девочке?");

                            familyController.bornChild(familyController.getFamilyById(Integer.parseInt(number) - 1), boyName, girlName);
                            System.out.println("Поздравляем, у вас родился ребенок!");
                            System.out.println(familyController.getFamilyById(Integer.parseInt(number) - 1));
                            continue outerLoop;
                        case "2":
                            number = askPrintAnsver("порядковый номер семьи?");
                            number = getString(number, checkInputIndex(number));
                            String gender = askPrintAnsver("Введите пол ребенка: male-мужской, female-женский");
                            boolean genderMorW = gender.toLowerCase().trim().equals("female");
                            familyController.adoptChild(familyController.getFamilyById(Integer.parseInt(number) - 1), createHuman(genderMorW, true));
                            continue outerLoop;
                        case "3":
                            continue outerLoop;
                        default:
                            System.out.println("Ошибка ввода!");
                            continue outerLoop;

                    }
                case "9":
                    number = askPrintAnsver("Укажите возраст ребенка, чтобы удалить его из семьи");
                    number = getString(number, checkInputNumber(number));
                    familyController.deleteAllChildrenOlderThen(Integer.parseInt(number));
                    continue outerLoop;
                case "10":
                    break outerLoop;
                default:
                    System.out.println("Что-то пошло не так!");
            }
        }
    }

    private String getString(String number, boolean checkMethod) {
        while (!checkMethod) {
            number = scanner.nextLine();
        }
        return number;
    }

    private boolean checkInputIndex(String index) {
        try {
            int indexCheck = Integer.parseInt(index);
            if(indexCheck>0 && indexCheck <= familyController.getAllFamilies().size()) return true;
        } catch (NumberFormatException e) {
            System.out.println("It is not index! Try print number!");
            return false;
        }
        System.out.println("There is not so many families!");
        return false;
    }

    private boolean checkInputNumber(String number) {
        try {
            int age = Integer.parseInt(number);
            if (age > 0 && age < 20)
                return true;
        } catch (NumberFormatException e) {
            System.out.println("It is not a number! Try again.");
            return false;
        }
        System.out.println("Try check number from 1 to 19");
        return false;
    }

    private Human createHuman(boolean gender, boolean child) {
        String name = askPrintAnsver(!child ? gender ? "Введите имя матери!" : "Введите имя отца!" : "Ввведите имя ребенка");
        String surname = askPrintAnsver(!child ? gender ? "Введите фамилию матери!" : "Введите фамилию отца!" : "Ввведите фамилию ребенка");
        String day = askPrintAnsver(!child ? gender ? "Введите день рождения матери!(дд)" : "Введите день рождения отца!(дд)" : "Ввведите день рождения  ребенка (дд)");
        getString(day, checkDay(day));

        String month = askPrintAnsver(!child ? gender ? "Введите месяц рождения матери!(мм)" : "Введите месяц рождения отца!(мм)" : "Ввведите месяц рождения  ребенка (мм)");

        try {
            if (Integer.parseInt(month) <1 || Integer.parseInt(month) > 12)
                throw new Exception("Введите день от 1 до 12!");
        }catch(Exception e){
            e.getMessage();
        }
        String year = askPrintAnsver(!child ? gender ? "Введите год рождения матери!(гггг)" : "Введите год рождения  отца!(гггг)" : "Ввведите год рождения  ребенка (гггг)");

        try {
            if (Integer.parseInt(year) < 1943) throw new Exception("Введите год рожденияб от 1943!");
        } catch(Exception e){
        e.getMessage();
        }
        String iq = askPrintAnsver(!child ? gender ? "Введите iq матери!" : "Введите iq отца!" : "Ввведите iq ребенка ");

        StringBuilder sb = new StringBuilder();
        sb.append(day).append("/").append(month).append("/").append(year);
        String dateOfBerth = sb.toString();

        Human human = gender ? new Woman(name, surname, dateOfBerth, Integer.parseInt(iq)) : new Man(name, surname, dateOfBerth, Integer.parseInt(iq));
        return human;
    }

    private boolean checkDay(String day) {
        try {
            int dayCheck = Integer.parseInt(day);
            if (dayCheck >= 1 && dayCheck <= 31) return true;
        } catch (NumberFormatException e){
            System.out.println("It is not a number!");
            return false;
        }
        System.out.println("Введите день от 1 до 31!");
        return false;
    }

    private boolean isDayOfBerthday(String dateOfBerth) {
        try {
            SDF.format((SDF.parse(dateOfBerth).equals(dateOfBerth)));
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private void displayChoiceList(String[] choices) {
        int id = 0;
        for (String choice : choices) {
            System.out.println((id + 1) + ". " + choice);
            ++id;
        }
    }
    private String askPrintAnsver(String s){
        System.out.println(s);
        return scanner.nextLine();
    }
}
