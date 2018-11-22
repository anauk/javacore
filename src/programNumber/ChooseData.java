package programNumber;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class ChooseData {
    public static void main(String[] args) {
        System.out.println("Enter your name");
        String[][] famousdata = createArray();
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        int rand = getRand(famousdata);
        System.out.println("Answer this " + name+" questuion: " + famousdata[rand][1]);
        play(famousdata[rand], in);
    }

    private static String[][] createArray() {
        String[][] famousdata= new String[5][2];
        famousdata[0][0] = "1998";
        famousdata[0][1] = "when was open disnay?";
        famousdata[1][0] = "2000";
        famousdata[1][1] = "bla?";
        famousdata[2][0] = "1945";
        famousdata[2][1] = "when was finished a Ware?";
        famousdata[3][0] = "1960";
        famousdata[3][1] = "Xz?";
        famousdata[4][0] = "1914";
        famousdata[4][1] = "asdf?";
        return famousdata;
    }

    private static void play(String[] famousdatum, Scanner in) {
        while(true){
            String t = in.nextLine();
                    if( t.equals(famousdatum[0])){
                        System.out.println("You won!");
                        break;
                    } else {
                        System.out.println("Try agane!");
                }
            }
    }

    private static int getRand(String[][] famousdata) {
        int lenRow = famousdata.length;
        int randIndex = new Random().nextInt(lenRow);
        return randIndex;
    }

}
