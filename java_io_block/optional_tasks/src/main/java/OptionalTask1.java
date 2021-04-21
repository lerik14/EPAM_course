import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptionalTask1 {
    // Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

    public static void task1() {
        String inputFileName = "java_io_block/optional_tasks/data/inputFileForTask1.txt";
        String outputFileName = "java_io_block/optional_tasks/data/outputFileForTask1.txt";
        writeNumbersInFile(inputFileName);
        writeSortedNumbersInFile(inputFileName, outputFileName);
    }

    public static void writeNumbersInFile(String inputFileName) {
        try (FileWriter inputFile = new FileWriter(inputFileName)) {
            int[] array = new int[10];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
                inputFile.write(array[i] + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Files handling problem", e);
        }
    }

    public static void writeSortedNumbersInFile(String readFileName, String writeFileName) {
        try (FileReader readFile = new FileReader(readFileName);
             FileWriter writeFile = new FileWriter(writeFileName)) {
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
