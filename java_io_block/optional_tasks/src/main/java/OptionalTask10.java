import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OptionalTask10 {
//    Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.

    public static void task10() {
        String readFileName = "java_io_block/optional_tasks/data/inputFileForTask10.txt";
        String writeFileName = "java_io_block/optional_tasks/data/outputFileForTask10.txt";
        replaceWordsInLine(readFileName, writeFileName);
    }

    public static void replaceWordsInLine(String readFileName, String writeFileName) {
        try (FileReader readFile = new FileReader(readFileName);
             FileWriter writeFile = new FileWriter(writeFileName)) {
            List<String> listOfElements = new ArrayList<>();
            BufferedReader reader = new BufferedReader(readFile);
            String line = reader.readLine();

            while (line != null) {
                listOfElements.add(line);
                line = reader.readLine();
            }

            for (String elem : listOfElements) {
                String[] word = elem.split("\\s+");
                String tmp = word[0];
                word[0] = word[word.length - 1];
                word[word.length - 1] = tmp;
                for (int i = 0; i < word.length - 1; i++) {
                    writeFile.write(word[i] + " ");
                }
                writeFile.write(word[word.length - 1] + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Files handling problem", e);
        }
    }
}
