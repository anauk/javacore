package programNumber;

public class ProgramNumTest {
    public static void main(String[] args) {
        System.out.println("Let the game begin!");
        InputName inName = new InputName();
        String inputName = inName.getName("Enter your name!");

        InputNumber in = new InputNumber();
        int randomNumber = (int)(Math.random()*100);
        System.out.println(randomNumber);
        boolean isPlay = true;
        while(isPlay) {
            String inputNumber = in.getUserInput("Enter number");
            /*int n = 0;*/
            try {
                int n = Integer.parseInt(inputNumber);
                if(n == randomNumber){
                    isPlay = false;
                    System.out.printf("Congratulations, %s!", inputName);
                } else if (n > randomNumber) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    System.out.println("Your number is too small. Please, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Try again!");
            }
            //int n = notNumber(inputNumber);

        }
    }

    private static int notNumber(String enterNum) {
        int n = 0;
        try {
             n = Integer.parseInt(enterNum);
             return n;
        } catch (NumberFormatException e) {
            System.out.println("Try again!");

        } catch (NullPointerException e) {
        }
        return n;
    }
}
