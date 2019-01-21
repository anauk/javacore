package main.homework1;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramNumber {
     public static void main(String[] args) {
        System.out.println("Let the game begin!");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name!");
        String name = in.nextLine();
        System.out.println(name);
        int randomNum = (int) (Math.random() * 100);
        System.out.println(randomNum);
        int pos = 0;
        int len = 3;
        int[] numbers = new int[len];
        int counter = 0;
        boolean isPlay = true;
        while (isPlay) {
            String s = in.nextLine();
            if (checkNumber(s)) {
                int number = Integer.parseInt(s);
                counter++;
                if (pos < len) {
                    numbers[pos++] = number;
                    System.out.println(Arrays.toString(numbers));
                } else {
                       numbers = saveNumber(numbers, number);
                }
                if (number == randomNum) {
                    isPlay = false;
                    System.out.printf("Congratulations, %s!", name);
                    sortArray(numbers);
                    System.out.println("You did " + counter + " tries!");
                } else if (number > randomNum) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    System.out.println("Your number is too small. Please, try again.");
                }
            }
        }
    }
    private static int[] saveNumber(int[] savedNum, int numberToSave) {
         int[] arr1 = Arrays.copyOf(savedNum, savedNum.length+1);
         arr1[arr1.length-1] = numberToSave;
        System.out.println(Arrays.toString(arr1));
        return arr1;
    }
    private static void sortArray(int[] numbers) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    isSorted = false;
                    buf = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static boolean checkNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Try again!");
            return false;
        }
        return true;
    }
}
