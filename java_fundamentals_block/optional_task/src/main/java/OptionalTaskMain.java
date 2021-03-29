import java.io.IOException;

public class OptionalTaskMain {

    public static void main(String[] args) throws IOException {
        int[] array = OptionalTask1.getElementsArrayFromConsole();

//      Java.Fundamentals Optional Task 1. number 1 Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int shortestElement = OptionalTask1.findShortestElement(array);
        System.out.println("The shortest element is " + shortestElement);
        System.out.println("The length of this element is " + OptionalTask1.elemLength(shortestElement));

        int longestElement = OptionalTask1.findLongestElement(array);
        System.out.println("The longest element is " + longestElement);
        System.out.println("The length of this element is " + OptionalTask1.elemLength(longestElement));


//      Java.Fundamentals Optional Task 1. number 2 Вывести числа в порядке возрастания значений их длины.
        OptionalTask1.sortByLength(array);

//       Java.Fundamentals Optional Task 1. number 3 Вывести на консоль те числа, длина которых  больше средней длины по всем числам, а также длину.
        double averageLength =  OptionalTask1.averageLength(array);
        System.out.println("\nThe average length is " + averageLength);
        OptionalTask1.elementsLongerThanAverageLength(array, averageLength);
        System.out.println("Elements longer than average length: " + OptionalTask1.elementsLongerThanAverageLength(array, averageLength) );
    }
}
