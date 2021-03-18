import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptionalTask1 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int[] inputElem() throws IOException {
        System.out.println("Enter the number of elements:");
        int numberOfElements = Integer.parseInt(reader.readLine());
        int[] array = new int[numberOfElements];
        System.out.println("Enter the elements:");
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    public static void findShortElement(int[] array) {
        int shortElem = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < shortElem) {
                shortElem = array[i];
            }
        }
        System.out.println("The shortest element is " + shortElem);
        System.out.println("The length of this element is " + elemLength(shortElem));
    }

    public static void findLongElement(int[] array) {
        int longElem = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > longElem) {
                longElem = array[i];
            }
        }
        System.out.println("The longest element is " + longElem);
        System.out.println("The length of this element is " + elemLength(longElem));
    }

    public static void sort(int[] array) {
        System.out.println("Elements sorted by length");
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int element : array) {
            System.out.print(element +" ");
        }
        System.out.println();
    }

    public static int elemLength(int element) {
        int elemLength = 0;
        while (element > 0) {
            element /= 10;
            elemLength++;
        }
        return elemLength;
    }

    public static void outputByAverageLength(int[] array) {
        int commonLength = 0;
        for (int i = 0; i < array.length; i++) {
            commonLength += elemLength(array[i]);
        }
        double averageLength = (double) commonLength / array.length;
        System.out.println("Elements longer than average length: ");
        for (int i = 0; i < array.length; i++) {
            if (elemLength(array[i]) > averageLength) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("\nThe average length is " + averageLength);
    }
}
