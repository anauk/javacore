package shooting;

import java.util.Arrays;
import java.util.Scanner;

public class ShootingSquareEnd {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[][] arr1 = getStringsArray();
        System.out.println("All set. Get ready to rumble!");
        int countTry = 0;
        int row = (int)(Math.random()*5);
        int coll = (int)(Math.random()*5);
        System.out.println(row);
        System.out.println(coll);
        boolean isPlay = true;
        while (isPlay) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            if(isNumber(s1)&&isNumber(s2)) {
                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                    if (n1 == row && n2 == coll) {
                        arr1[n1][n2] = "x";
                        System.out.printf("You won with %d hit!", countTry);
                        System.out.println();
                        isPlay = false;
                    } else {
                        try {
                            arr1[n1][n2] = "*";
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Enter number<5");
                        }
                    }
                    printSquare(arr1);
                    countTry++;
            }
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] arr1 = getStringsArray();
        System.out.println("All set. Get ready to rumble!");
        int countTry = 0;
        int numOfHits=0;
        int rand = (int)(Math.random()*5);
        int[] randShip = {rand, rand+1, rand+2};
        /*int coll = (int)(Math.random()*5);
        int[] randColl = {coll, coll+1, coll+2};*/
        System.out.println(rand);
        /*System.out.println(coll);*/
        System.out.println(Arrays.toString(randShip));
        /*System.out.println(Arrays.toString(randColl));*/
        while(countTry<3) {
            String s = in.nextLine();
            int n1 = Integer.parseInt(s);
            String result;
            for (int i = 0; i <randShip.length ; i++) {
                if(n1 == randShip[i]){
                    result = "x";
                    countTry++;
                    randShip[i] = -1;
                    break;
                } else {
                    result = "*";
                }
            }
                    numOfHits++;
            System.out.println("You did it!");
        }
        /*boolean isPlay = true;
        while (isPlay) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            if(isNumber(s1)&&isNumber(s2)) {
                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                if (n1 == rand && n2 == coll) {
                    arr1[n1][n2] = "x";
                    System.out.printf("You won with %d hit!", countTry);
                    System.out.println();
                    isPlay = false;
                } else {
                    arr1[n1][n2] = "*";
                }

                printSquare(arr1);
                countTry++;
            }
        }*/
    }
    public String checkHit(String s, int[] rand) {
        int numOfHits=0;
        int n1 = Integer.parseInt(s);
        String result = "x";
        for (int i = 0; i <rand.length ; i++) {
            if(n1 == rand[i]){
                result = "x";
                numOfHits++;
                rand[i] = -1;
                break;
            } else {
              result = "*";
            }
        }
        /*if(numOfHits==rand.length) {
            result = "x";
            System.out.println(result);
        }*/
        numOfHits++;
        return result;
    }
    private static String[][] getStringsArray() {
        String[][] arr1 = new String [5][5];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = "-";
            }
        }
        return arr1;
    }

    private static void printSquare(String[][] arr1) {
        int row = 0;
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(row++ +"| ");
                for (int j = 0; j < arr1[i].length; j++) {
                    System.out.print(arr1[i][j] + " | ");
                }
                System.out.println();
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

}
