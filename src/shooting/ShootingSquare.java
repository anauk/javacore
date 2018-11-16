package shooting;

import java.util.Arrays;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class ShootingSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] arr1 = new int[5][5];
        int x=1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j]=x++;
            }
            System.out.println();
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("All set. Get ready to rumble!");
        int countTry = 0;
        //RandomCells theRandomCells = new RandomCells();
        int rand = (int)(Math.random()*26);
        //int[] arr = {rand, rand+1};
        //theRandomCells.setLocCells(arr);
        System.out.println(rand);
        boolean isPlay = true;
        while (isPlay) {
            String s1 = in.nextLine();
            if(isNumber(s1)) {
                int s = Integer.parseInt(s1);
                int result = 0;

                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr1[i].length; j++) {
                        if (s == rand && s == arr1[i][j]) {
                            arr1[i][j] = result;
                            System.out.printf("You won with %d hit!", countTry);
                            isPlay = false;
                        }
                        if (s != rand && s == arr1[i][j]) {
                            arr1[i][j] = 111;
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr1[i].length; j++) {
                        System.out.print(arr1[i][j] + "  ");
                    }
                    System.out.println();
                }
                //String result = theRandomCells.getHit(s);
                countTry++;

            }

      /* if(result.equals("x")) {
           isPlay=false;
           System.out.printf("You did %s trys!", countTry );
       }*/
        //System.out.println("Try, try, try!");
    }

    }

    private static boolean isNumber(String s) {
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
