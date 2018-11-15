package programNumber;

import java.util.Scanner;
public class ProgramNumber {
    public static void main(String[] args) {
        System.out.println("Let the game begin!");
    Scanner in = new Scanner(System.in);
        System.out.println("Enter your name!");
    String name = in.nextLine();
        System.out.println(name);

    int randomNum = (int)(Math.random()*100);
        System.out.println(randomNum);

        boolean isPlay = true;
        while(isPlay) {
            String s = in.nextLine();
            if(checkNumber(s)){
                int number = Integer.parseInt(s);
                if(number == randomNum){
                    isPlay = false;
                    System.out.printf("Congratulations, %s!", name);
                } else if (number > randomNum) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    System.out.println("Your number is too small. Please, try again.");
                }
            }
        }
    }

    private static boolean checkNumber(String number) {
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Try again!");
            return false;
        }
        return true;
    }
}
