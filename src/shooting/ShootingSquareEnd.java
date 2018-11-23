package shooting;

import java.util.Arrays;
import java.util.Scanner;

public class ShootingSquareEnd {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[][] arr1 = getStringsArray();
        System.out.println("All set. Get ready to rumble!");
        int countTry = 0;
        int row = (int)(Math.random()*5)+1;
        int coll = (int)(Math.random()*5)+1;
        System.out.println(row);
        System.out.println(coll);
        boolean isPlay = true;
        while (isPlay) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            if(isNumber(s1)&&isNumber(s2)) {
                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                countTry++;
                    if (n1 == row && n2 == coll) {
                        arr1[n1][n2] = "x";
                        System.out.printf("You won with %d hit!", countTry);
                        System.out.println();
                        isPlay = false;
                    } else {

                        try {
                            if((n1==0||n1>5) &&(n2==0||n2>5)){
                                System.out.println("Try again!");
                            }
                            arr1[n1][n2] = "*";

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Enter number with 1 to 5");
                        }
                    }
                    printSquare(arr1);

            }
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] arr1 = getStringsArray();
        System.out.println("All set. Get ready to rumble!");
        int countTry = 0;
        int numOfHits=0;
        int row = (int)(Math.random()*arr1.length);
        int col = (int)(Math.random()*arr1[0].length);
        int[][] randShip = new int[3][1];
        randShip[row][col]=1;
        randShip[row+1][col]=1;
        randShip[row+2][col]=1;
        /*int coll = (int)(Math.random()*5);
        int[] randColl = {coll, coll+1, coll+2};*/
        /*System.out.println(coll);*/
        System.out.println(Arrays.deepToString(randShip));
        /*System.out.println(Arrays.toString(randColl));*/
        /*while(countTry<3) {
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
        }*/
        boolean isPlay = true;
        while (isPlay) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            if(isNumber(s1)&&isNumber(s2)) {
                int n1 = Integer.parseInt(s1);
                int n2 = Integer.parseInt(s2);
                for (row = 0; row < randShip.length; row++) {
                    for (col = 0; col < randShip[row].length; col++) {
                        if (n1 == row && n2 == col) {
                            arr1[n1][n2] = "x";
                            numOfHits++;
                            System.out.printf("You won with %d hit!", countTry);
                            System.out.println();
                            isPlay = false;
                        } else if ((n1 == row && n2 != col) || (n1 != row && n2 == col)) {
                            arr1[n1][n2] = "*";
                        } else {
                            arr1[n1][n2] = "-";
                        }
                    }
                }
                printSquare(arr1);
                countTry++;
            }
        }
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
        String[][] arr1 = new String [6][6];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 1; j < arr1[i].length; j++) {
                arr1[i][j] = "-";
            }
        }
        return arr1;
    }

    private static void printSquare(String[][] arr1) {
        int row = 0;
        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(row++ +"| ");
            for (int j = 1; j < arr1[i].length; j++) {
                if(i == 0){
                    System.out.print(++num +" | ");
                } else{
                    System.out.print(arr1[i][j] + " | ");}
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
