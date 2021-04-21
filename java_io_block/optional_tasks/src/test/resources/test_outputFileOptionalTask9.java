import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Task1 {



    public static void task1() {
        String inputFileName = "java_collections_block/optional_tasks/src/main/resources/Input_file_for_task1.txt";
        String outputFileName = "java_collections_block/optional_tasks/src/main/resources/Output_file_for_task1.txt";
        List<String> listOfFileLines;

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(inputFileName));
            listOfFileLines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }


        Collections.reverse(listOfFileLines);

        try {
            Files.write(Paths.get(outputFileName), listOfFileLines);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write into file", e);
        }
    }
}
