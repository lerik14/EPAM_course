import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptionalTask1 {
    // Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

    public static void task1() {
        writeNumbersInFile();
        writeSortedNumbersInFile();
    }

    public static void writeNumbersInFile() {
        try (FileWriter inputFile = new FileWriter("java_io_block/optional_tasks/data/inputFileForTask1.txt")) {
            int[] array = new int[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
                inputFile.write(array[i] + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Files handling problem", e);
        }
    }

    public static void writeSortedNumbersInFile() {
        try (FileReader readFile = new FileReader("java_io_block/optional_tasks/data/inputFileForTask1.txt");
             FileWriter writeFile = new FileWriter("java_io_block/optional_tasks/data/outputFileForTask1.txt")) {
            List<Integer> listOfElements = new ArrayList<>();
            BufferedReader reader = new BufferedReader(readFile);
            String line = reader.readLine();

            while (line != null) {
                listOfElements.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            Collections.sort(listOfElements);

            for (int element : listOfElements) {
                writeFile.write(element + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Files handling problem", e);
        }
    }
}
