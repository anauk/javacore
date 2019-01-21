package main.homework1;

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
            String input = in.getUserInput("Enter number");
            if (isNumber(input)) {
                int n = Integer.parseInt(input);
                int len = 10;
                int[] arr = new int[len];
                for (int i = 0; i < arr.length; i++) {
                    arr[i]= n;
                }
                if(n == randomNumber){
                    isPlay = false;
                    out.printf("Congratulations, %s!", inputName);
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                } else if (n > randomNumber) {
                    out.println("Your number is too big. Please, try again.");
                } else {
                    out.println("Your number is too small. Please, try again.");
                }
            }
        }
    }
    private static boolean isNumber(String in) {
      try {
          Integer.parseInt(in);
      } catch (NumberFormatException e) {
          return false;
      }
      return true;
    }

    /*private static int[] saveNumber(int[] savedNum, int numberToSave) {
    int pos = 0;
        int len = 10;
        int[] numbers = new int[len];
        if(pos<len){
        numbers[pos++]=numberToSave;
        }
        return numbers;
    }*/
    /*private static List<Integer> createArrayList(String inputNumber) {
        List<Integer> integers = new ArrayList<>();
        while(true) {
        if("EXIT".equals(inputNumber) break;
            integers.add(parseInt(inputNumber));
            return integers;
        }
    }*/

}
