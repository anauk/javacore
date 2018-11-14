package programNumber;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.*;
import static java.util.Collections.sort;

public class ProgramNumTest {
    public static void main(String[] args) {
        out.println("Let the game begin!");
        InputName inName = new InputName();
        String inputName = inName.getName("Enter your name!");

        InputNumber in = new InputNumber();
        int randomNumber = (int)(Math.random()*100);
        out.println(randomNumber);
        boolean isPlay = true;
        while(isPlay) {
            String inputNumber = in.getUserInput("Enter number");

            /*int n = 0;*/
            try {
                int n = parseInt(inputNumber);
                if(n == randomNumber){
                    isPlay = false;
                    out.printf("Congratulations, %s!", inputName);
                } else if (n > randomNumber) {
                    out.println("Your number is too big. Please, try again.");
                } else {
                    out.println("Your number is too small. Please, try again.");
                }
            } catch (NumberFormatException e) {
                out.println("Try again!");
            }
            //int n = notNumber(inputNumber);
            out.println(createArrayList(inputNumber));
        }
    }
    private static List<Integer> createArrayList(String inputNumber) {
        List<Integer> integers = new ArrayList<>();
        while(true) {
            integers.add(parseInt(inputNumber));
            return integers;
        }

    }
    private static int notNumber(String enterNum) {
        int n = 0;
        try {
             n = parseInt(enterNum);
             return n;
        } catch (NumberFormatException e) {
            out.println("Try again!");

        } catch (NullPointerException e) {
        }
        return n;
    }

}
