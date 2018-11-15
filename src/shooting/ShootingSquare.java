package shooting;

import java.util.Arrays;
import java.util.Scanner;

public class ShootingSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] square = new int[5][5];

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print("- " + "\t");
            }
            System.out.println();
        }
        int[] squ = new int[5];
        System.out.println(getRandom(squ));
        System.out.println("All set. Get ready to rumble!");


        boolean isPlay = true;
        while (isPlay) {
            int hit = in.nextInt();

                if (hit == getRandom(squ)) {
                    for (int aSqu : squ) {
                        System.out.print("* ");
                    }
                    System.out.println("You have won!");
                    isPlay = false;
                } else {
                    System.out.println("Try, try, try!");
                }

        }
    }

        private static int getRandom ( int[] arr){
            int rnd = (int) (Math.random()*arr.length);
            return arr[rnd];
        }

}
