package shooting;

import java.util.Scanner;

public class ShootingSquareEnd {
    public static void main(String[] args) {
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
                        arr1[n1][n2] = "*";
                    }
                printSquare(arr1);
                countTry++;
            }
        }
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
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    System.out.print(arr1[i][j] + "  ");
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
