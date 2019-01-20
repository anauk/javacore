package homework17.exception;
import homework17.ConsoleApp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingMethods {
    private  Scanner scanner = new Scanner(System.in);
    public  String checkInputString(String question) {
        System.out.println(question);
        String name;
        int sizeName;
        while (true) {
            name = scanner.nextLine();
            try {
                sizeName = name.length();
                if (sizeName == 0) throw new NullPointerException("Can not be null!");
                for (int i = 0; i < sizeName; i++) {
                    if (Character.isDigit(name.charAt(i))) throw new NumberFormatException("Can not be number!");
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return name;
    }

    public boolean isGenderMenOrWomen(String s) {
        System.out.println(s);
        String gender;
        boolean genderMorW;
        while(true){
            gender = scanner.nextLine();
            if(gender.toLowerCase().trim().equals("female")) {
                genderMorW = true;
            } else if(gender.toLowerCase().trim().equals("male")) {
                genderMorW = true;
            } else {
                System.out.println("Enter male or female");
                continue;
            }
            break;
        }
        return genderMorW;
    }

    public int getCorrectNumber(String question) {
        System.out.println(question);
        int number;
        while (true) {
            try {
                number = scanner.nextInt();
                if (number < 0 || number > ConsoleApp.familyController.getAllFamilies().size()) throw new GoingBeyond("I did not find family with such index!");
                if( number == 0 ) break;
            } catch (InputMismatchException|GoingBeyond e) {
                System.out.println("Write a number!");
                System.out.println(e.getMessage());
                scanner.nextLine();
                continue;
            }
            break;
        }
        return number;
    }

    public String checkInputNumber(String question) {
        System.out.println(question);
        String number;
        int age;
        while (true) {
            number = scanner.nextLine();
            try {
                age = Integer.parseInt(number);
                if (age < 0 || age > 20) throw new GoingBeyond("Try check number from 1 to 19");
            } catch (NumberFormatException | GoingBeyond e) {
                System.out.println("Try again.");
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return number;
    }

    public String checkIq() {
        String iq;
        int iqCheck;
        while (true) {
            iq = scanner.nextLine();
            try {
                iqCheck = Integer.parseInt(iq);
                if (iqCheck < 1 || iqCheck > 99) throw new GoingBeyond("Введите iq от 1 до 99!");
            } catch (GoingBeyond | NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("It is not a number!");
                continue;
            }
            break;
        }
        return iq;
    }

    public String checkDay() {
        String day;
        int dayCheck;
        while (true) {
            day = scanner.nextLine();
            try {
                dayCheck = Integer.parseInt(day);
                if (dayCheck < 1 || dayCheck > 31) throw new GoingBeyond("Введите день от 1 до 31!");
            } catch (NumberFormatException | GoingBeyond e) {
                System.out.println(e.getMessage());
                System.out.println("It is not a number!");
                continue;
            }
            break;
        }
        return day;
    }

    public String checkMonth() {
        String month;
        int monthCheck;
        while (true) {
            month = scanner.nextLine();
            try {
                monthCheck = Integer.parseInt(month);
                if (monthCheck < 1 || monthCheck > 12) throw new GoingBeyond("Введите  месяц от 1 до 12!");
            } catch (NumberFormatException | GoingBeyond e) {
                System.out.println(e.getMessage());
                System.out.println("It is not a number!");
                continue;
            }
            break;
        }
        return month;
    }

    public String checkYear() {
        String year;
        int yearCheck;
        while (true) {
            year = scanner.nextLine();
            try {
                yearCheck = Integer.parseInt(year);
                if (yearCheck < 1943 || yearCheck > 2018)
                    throw new InputMismatchException("Введите год от 1943 до 2018!");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("It is not a number!");
                continue;
            }
            break;
        }
        return year;
    }

    public void displayChoiceList(String[] choices) {
        int id = 0;
        for (String choice : choices) {
            System.out.println((id + 1) + ". " + choice);
            ++id;
        }
    }

    public String checkPrintAnsver() {
        System.out.println("Укажите количество людей в семье:");
        String number;
        int quantity;
        while (true) {
            number = scanner.nextLine();
            try {
                quantity = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
                continue;
            }
            break;
        }
        return number;
    }
}
