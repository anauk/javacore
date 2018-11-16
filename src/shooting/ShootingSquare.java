package shooting;

import java.util.Arrays;
import java.util.Scanner;

public class ShootingSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = 5;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("- " + "\t");
            }
            System.out.println();
        }
        System.out.println("All set. Get ready to rumble!");
        int[] arrRow = new int[]{1,2,3,4,5};
int row = getRandom(arrRow);
int col = getRandom(arrRow);
        System.out.println(row);
        System.out.println(col);
        boolean isPlay = true;
        while (isPlay) {
            String s = in.nextLine();
            if(checkNum(s)) {
    int hit = Integer.parseInt(s);
    if (hit == row) {
            System.out.print("*");
        }
        System.out.println("You have won!");
        isPlay = false;
    } else {
        System.out.println("Try, try, try!");
    }
}
    }

    private static boolean checkNum(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int getRandom ( int[] arr){
            int rnd = (int) (Math.random()*arr.length);
            return arr[rnd];
        }

}
