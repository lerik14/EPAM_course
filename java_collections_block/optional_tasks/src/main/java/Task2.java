import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Task2 {

//    Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

    public static void task2() {
        System.out.println("Input number: ");
        String inputNumber = "";
        StringBuilder outputNumber = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            inputNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] inputNumberArr = inputNumber.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (Character elem : inputNumberArr) {
            stack.push(elem);
        }

        for (int i = stack.size(); i > 0; i--) {
            outputNumber.append(stack.pop());
        }

        System.out.println(outputNumber);
    }
}
