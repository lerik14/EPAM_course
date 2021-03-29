import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OptionalTask1 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int[] getElementsArrayFromConsole() throws IOException {
        System.out.println("Enter the number of elements:");
        int numberOfElements = Integer.parseInt(reader.readLine());
        int[] array = new int[numberOfElements];
        System.out.println("Enter the elements:");
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    public static int findShortestElement(int[] array) {
        int shortestElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < shortestElement) {
                shortestElement = array[i];
            }
        }
        return  shortestElement;
    }

    public static int findLongestElement(int[] array) {
        int longestElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > longestElement) {
                longestElement = array[i];
            }
        }
        return  longestElement;
    }

    public static void sortByLength(int[] array) {
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

    public static List<Integer> elementsLongerThanAverageLength(int[] array, double averageLength) {
        List<Integer> elementsLongerThanAverageLength = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (elemLength(array[i]) > averageLength) {
               elementsLongerThanAverageLength.add(array[i]);
            }
        }
        return elementsLongerThanAverageLength;
    }

    public static double averageLength(int[] array) {
        int commonLength = 0;
        for (int i = 0; i < array.length; i++) {
            commonLength += elemLength(array[i]);
        }
        return (double) commonLength / array.length;
    }
}
