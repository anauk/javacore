package main.homework3;

import java.util.Scanner;

public class TasksWeekChang {
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
            String s = in.nextLine();
            int index = s.indexOf("change");
            if(index == -1){
                if(s.length() == 0 ) {break;}
                getDoTask(scedule, s);
                System.out.println("Please, input the day of the week again:");
            } else {
                if(s.contains("monday")){
                    System.out.println("Please, input new tasks for Monday." );
                    scedule[1][1] = in.nextLine().toLowerCase();
                } else if (s.contains("sunday")) {
                    System.out.println("Please, input new tasks for sunday." );
                    scedule[0][1] = in.nextLine().toLowerCase();
                } else if (s.contains("tuesday")) {
                    System.out.println("Please, input new tasks for tuesday." );
                    scedule[2][1] = in.nextLine().toLowerCase();
                }else if (s.contains("wednesday")) {
                    System.out.println("Please, input new tasks for wednesday." );
                    scedule[3][1] = in.nextLine().toLowerCase();
                }else if (s.contains("thursday")) {
                    System.out.println("Please, input new tasks for thursday." );
                    scedule[4][1] = in.nextLine().toLowerCase();
                }else if (s.contains("friday")) {
                    System.out.println("Please, input new tasks for friday." );
                    scedule[5][1] = in.nextLine().toLowerCase();
                }else if (s.contains("saturday")) {
                    System.out.println("Please, input new tasks for saturday." );
                    scedule[6][1] = in.nextLine().toLowerCase();
                } else {
                    System.out.println("It is mistake!");
                }
                if(s.length() == 0 ) {break;}
                System.out.println("Please, input the day of the week:");
            }
        }
        System.out.println("Bay!");
    }
    private static void getDoTask(String[][] scedule, String s) {
        System.out.println("You entered: " + s);
        switch (s.trim().toLowerCase()) {
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
