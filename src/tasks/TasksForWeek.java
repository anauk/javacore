package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class TasksForWeek{
    public static void main(String[] args) {
        String[][] scedule = new String[7][2];
        scedule[0][0] = "sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "monday";
        scedule[1][1] = "go to courses; watch a film";
        scedule[2][0] = "tuesday";
        scedule[2][1] = "plaing";
        scedule[3][0] = "wednesday";
        scedule[3][1] = "sweeming";
        scedule[4][0] = "thursday";
        scedule[4][1] = "do what you want";
        scedule[5][0] = "friday";
        scedule[5][1] = "meet with parents";
        scedule[6][0] = "saturday";
        scedule[6][1] = "bla bla bla";
        Scanner in = new Scanner(System.in);
        System.out.println("Please, input the day of the week:");
        while(in.hasNextLine()) {
            String s = in.nextLine();int index = s.indexOf("change");
            if(index == -1){
                if(s.length() == 0 ) {break;}
                getDoTask(scedule, s);
                System.out.println("Please, input the day of the week again:");
            } else {
                scedule = new String[scedule.length][scedule[0].length];
                for (int i = 0; i < scedule.length; i++) {
                    for (int j = 0; j < scedule[i].length; j++) {
                        if(s.length() == 0 ) {break;}
                        System.out.print("Input your day " + i + " and task on this day: " + j+ ":");
                        scedule[i][j] = in.nextLine();
                        }
                }
                for (String[] aScedule : scedule) {
                    for (String anAScedule : aScedule) {
                        System.out.print(anAScedule + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }
        System.out.println("Bay!");
    }

    private static void getDoTask(String[][] scedule, String s) {
        System.out.println("You entered: " + s);
        switch (s.trim().toLowerCase()) {
            case "EXIT": break;
            case "sunday":
                System.out.println("Your tasks for Sunday: " + scedule[0][1]);
                break;
            case "monday":
                System.out.println("Your tasks for Monday: " + scedule[1][1]);
                break;
            case "tuesday":
                System.out.println("Your tasks for Tuesday: " + scedule[2][1]);
                break;
            case "wednesday":
                System.out.println("Your tasks for Wednesday: " + scedule[3][1]);
                break;
            case "thursday":
                System.out.println("Your tasks for Thursday: " + scedule[4][1]);
                break;
            case "friday":
                System.out.println("Your tasks for Friday: " + scedule[5][1]);
                break;
            case "saturday":
                System.out.println("Your tasks for Saturday: " + scedule[6][1]);
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
        }
    }
}
