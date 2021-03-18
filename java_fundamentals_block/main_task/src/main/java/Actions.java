import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Actions { //Main tasks in Java Fundamentals block

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void helloUser() throws IOException {
        System.out.println("Enter your name:");
        String userName = reader.readLine();
        System.out.println("Hello, " + userName +"!");
    }

    public static void arrayReverse() throws IOException {
        System.out.println("Enter the sequence separated by a space:");
        String sequence = reader.readLine();
        String[] elements = sequence.split(" ");

        for (int i = elements.length - 1; i >= 0; i--) {
            System.out.print(elements[i] +" ");
        }
        System.out.println();
    }

    public static void randomNumbers() throws IOException {
        System.out.println("Enter the number of elements:");
        int numberOfElements = Integer.parseInt(reader.readLine());
        int[] array = new int[numberOfElements];
        Random random = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt();
        }
        for (int element : array) {
            System.out.println(element);
        }
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void sumAndMultiple() throws IOException {
        int sum = 0;
        int multiple = 1;

        System.out.println("Enter the numbers:");
        while (true) {
            String input = reader.readLine();
            if (!input.equals("")) {
                int number = Integer.parseInt(input);
                sum += number;
                multiple *= number;
            }
            else {
                break;
            }
        }
        System.out.println("The sum of all numbers is " + sum);
        System.out.println("The product of all numbers is " + multiple);
    }

    public static void monthNumber() throws IOException {
        System.out.println("Enter the number between 1 and 12:");
        int number = Integer.parseInt(reader.readLine());
        String monthName;

        switch (number) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                throw new IllegalArgumentException("Entered wrong number " + number);
        }
        System.out.println("The month is " + monthName);
    }
}
