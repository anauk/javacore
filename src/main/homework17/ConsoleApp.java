package homework17;
import homework17.exception.CheckingMethods;
import homework17.famelyDao.CollectionFamilyDao;
import homework17.famelyDao.FamilyController;
import homework17.famelyDao.FamilyDao;
import homework17.famelyDao.FamilyService;
import homework17.family.Human;
import homework17.family.Man;
import homework17.family.Woman;
import java.util.*;


public class ConsoleApp {
    private Scanner scanner = new Scanner(System.in);
    CheckingMethods cm = new CheckingMethods();

    private String[] choices1 = {"Заполнить тестовыми данными.", "Отобразить весь список семей",
            "Отобразить список семей, где количество людей больше заданного", "Отобразить список семей, где количество людей меньше заданного",
            "Подсчитать количество семей, где количество членов равно", "Создать новую семью",
            "Удалить семью по индексу семьи в общем списке", "Редактировать семью по индексу семьи в общем списке",
            "Удалить всех детей старше возраста...", "Exit"};
    private String[] choices2 = {"Родить ребенка", "Усыновить ребенка",
            "Вернуться в главное меню"};
    public static FamilyDao familyDao = new CollectionFamilyDao();
    public static FamilyService familyService = new FamilyService(familyDao);
    public static FamilyController familyController = new FamilyController(familyService);

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
            cm.displayChoiceList(choices1);
            String number;
            int numberOfInput;
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
                    number = cm.checkPrintAnsver();
                    familyController.getFamiliesBiggerThan(Integer.parseInt(number));
                    continue outerLoop;
                case "4":
                    number = cm.checkPrintAnsver();
                    familyController.getFamiliesLessThan(Integer.parseInt(number));
                    continue outerLoop;
                case "5":
                    number = cm.checkPrintAnsver();
                    System.out.println("Количество семей, где количество людей " + number + " = " + familyController.countFamiliesWithMemberNumber(Integer.parseInt(number)));
                    continue outerLoop;
                case "6":
                    familyController.createNewFamily(createHuman(true, false), createHuman(false, false));
                    continue outerLoop;
                case "7":
                    numberOfInput = cm.getCorrectNumber("Укажите порядковый номер семьи: ");
                    familyController.deleteFamilyByIndex(numberOfInput);
                    continue outerLoop;
                case "8":
                    cm.displayChoiceList(choices2);
                    String chooze = scanner.nextLine();
                    switch (chooze) {
                        case "1":
                            numberOfInput = cm.getCorrectNumber("Укажите порядковый номер семьи: ");
                            String boyName = cm.checkInputString("какое имя дать мальчику?");
                            String girlName = cm.checkInputString("какое имя дать девочке?");

                            familyController.bornChild(familyController.getFamilyById(numberOfInput-1), boyName, girlName);
                            System.out.println("Поздравляем, у вас родился ребенок!");
                            System.out.println(familyController.getFamilyById(numberOfInput-1));
                            continue outerLoop;
                        case "2":
                            numberOfInput = cm.getCorrectNumber("Укажите порядковый номер семьи: ");
                            boolean genderMorW = cm.isGenderMenOrWomen("Введите пол ребенка: male-мужской, female-женский");
                            familyController.adoptChild(familyController.getFamilyById(numberOfInput-1), createHuman(genderMorW, true));
                            continue outerLoop;
                        case "3":
                            continue outerLoop;
                        default:
                            System.out.println("Ошибка ввода!");
                            continue outerLoop;

                    }
                case "9":
                    number = cm.checkInputNumber("Укажите возраст ребенка, чтобы удалить его из семьи");
                    familyController.deleteAllChildrenOlderThen(Integer.parseInt(number));
                    continue outerLoop;
                case "10":
                    break outerLoop;
                default:
                    System.out.println("Что-то пошло не так!");
            }
        }
    }

    private Human createHuman(boolean gender, boolean child) {
        String name = cm.checkInputString(!child ? gender ? "Введите имя матери!" : "Введите имя отца!" : "Ввведите имя ребенка");
        String surname = cm.checkInputString(!child ? gender ? "Введите фамилию матери!" : "Введите фамилию отца!" : "Ввведите фамилию ребенка");

        System.out.println(!child ? gender ? "Введите день рождения матери!(дд)" : "Введите день рождения отца!(дд)" : "Ввведите день рождения  ребенка (дд)");
        String day = cm.checkDay();
        System.out.println(!child ? gender ? "Введите месяц рождения матери!(мм)" : "Введите месяц рождения отца!(мм)" : "Ввведите месяц рождения  ребенка (мм)");
        String month = cm.checkMonth();
        System.out.println(!child ? gender ? "Введите год рождения матери!(гггг)" : "Введите год рождения  отца!(гггг)" : "Ввведите год рождения  ребенка (гггг)");
        String year = cm.checkYear();
        System.out.println(!child ? gender ? "Введите iq матери!" : "Введите iq отца!" : "Ввведите iq ребенка ");
        String iq = cm.checkIq();
        StringBuilder sb = new StringBuilder();
        sb.append(day).append("/").append(month).append("/").append(year);
        String dateOfBerth = sb.toString();

        Human human = gender ? new Woman(name, surname, dateOfBerth, Integer.parseInt(iq)) : new Man(name, surname, dateOfBerth, Integer.parseInt(iq));
        return human;
    }
}
