import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utilites {
    public static void printMenu(){
        System.out.println("Menu:");
        System.out.println("1.Load your history from file");
        System.out.println("2.Save your history to file");
        System.out.println("3.Show operations from period");
        System.out.println("4.Add operation to your history");
        System.out.println("5.Show statistic from refill");
        System.out.println("6.Show statistic from waste");
        System.out.println("7.Show sorted operations");
    }

    public static void clearConsole(int steps){
        for (int i = 0; i < steps; i++) {
            System.out.println();
        }
    }

   public static int enteringIntValue(String message, int rightSide, int leftSide) {
        System.out.println(message);

        int value = 0;
        boolean error;

        do {
            error = false;

            try {
                Scanner sc = new Scanner(System.in);
                value = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("It is not a number.");
                error = true;
            }

            if (value > rightSide || value < leftSide) {
                error = true;
                System.out.println("Wrong value");
            }

        } while (error);

        return value;
    }

    public static String enteringDate(String message){

        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[a-z]{3}\s[a-z]{3}\s[0-9]{1,2}\s[0-2][0-9]:[0-6][0-9]:[0-6][0-9]\s[a-z]{3}\s[0-9]{4}");
        String time="Sat Jan 1 00:00:00 MSK 2000";

        boolean error = false;
        do {
            error = false;
            try {
                System.out.println(message);
                System.out.println("Format example: Wed Jul 27 15:57:49 MSK 2022");
                time = sc.next(pattern);
            } catch (InputMismatchException e) {
                error = true;
                System.out.println("Wrong date format!");
            }
        } while (error);

        return time;
    }




}
