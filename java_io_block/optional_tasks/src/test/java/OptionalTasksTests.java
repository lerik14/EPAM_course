import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class OptionalTasksTests {

    @Test
    public void optionalTask1Test() throws IOException {
        String readFileName = "optional_tasks/src/test/resources/test_inputFileOptionalTask1.txt";
        String writeFileName = "optional_tasks/src/test/resources/outputFileOptionalTask1.txt";
        OptionalTask1.writeSortedNumbersInFile(readFileName, writeFileName);
        BufferedReader br = Files.newBufferedReader(Paths.get(writeFileName));
        List<String> listOfStringsActual = br.lines().collect(Collectors.toList());
        br = Files.newBufferedReader(Paths.get("optional_tasks/src/test/resources/test_outputFileOptionalTask1.txt"));
        List<String> listOfStringsExpected = br.lines().collect(Collectors.toList());
        assertEquals(listOfStringsExpected, listOfStringsActual);
    }

    @Test
    public void optionalTask9Test() throws IOException {
        String readFileName = "optional_tasks/data/javaFileForTask9.java";
        String writeFileName = "optional_tasks/src/test/resources/outputFileOptionalTask9.java";
        OptionalTask9.deleteCommentsInFile(readFileName, writeFileName);
        BufferedReader br = Files.newBufferedReader(Paths.get(writeFileName));
        List<String> listOfStringsActual = br.lines().collect(Collectors.toList());
        br = Files.newBufferedReader(Paths.get("optional_tasks/src/test/resources/test_outputFileOptionalTask9.java"));
        List<String> listOfStringsExpected = br.lines().collect(Collectors.toList());
        assertEquals(listOfStringsExpected, listOfStringsActual);

    }

    @Test
    public void optionalTask10Test() throws IOException {
        String readFileName = "optional_tasks/src/test/resources/test_inputFileOptionalTask10.txt";
        String writeFileName = "optional_tasks/src/test/resources/created_outputFileOptionalTask10.txt";
        OptionalTask10.replaceWordsInLine(readFileName, writeFileName);
        BufferedReader br = Files.newBufferedReader(Paths.get(writeFileName));
        List<String> listOfStringsActual = br.lines().collect(Collectors.toList());
        br = Files.newBufferedReader(Paths.get("optional_tasks/src/test/resources/test_outputFileOptionalTask10.txt"));
        List<String> listOfStringsExpected = br.lines().collect(Collectors.toList());
        assertEquals(listOfStringsExpected, listOfStringsActual);
    }
}
