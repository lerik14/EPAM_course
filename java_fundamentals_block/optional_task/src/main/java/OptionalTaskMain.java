import java.io.IOException;

public class OptionalTaskMain {

    public static void main(String[] args) throws IOException {
        int[] array = OptionalTask1.inputElem();

//      Java.Fundamentals Optional Task 1. number 1 Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        OptionalTask1.findShortElement(array);
        OptionalTask1.findLongElement(array);

//      Java.Fundamentals Optional Task 1. number 2 Вывести числа в порядке возрастания значений их длины.
        OptionalTask1.sort(array);

//       Java.Fundamentals Optional Task 1. number 3 Вывести на консоль те числа, длина которых  больше средней длины по всем числам, а также длину.
        OptionalTask1.outputByAverageLength(array);
    }
}
