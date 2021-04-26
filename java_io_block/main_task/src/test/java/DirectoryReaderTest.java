import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DirectoryReaderTest {

    @Test
    public void creatingFileWithDirInfo() throws IOException {
        Path directory = Paths.get("main_task/src/test/resources/test_data");
        DirectoryReader.MyFileVisitor visitor = new DirectoryReader.MyFileVisitor(directory);
        Files.walkFileTree(directory, visitor);
        String output = "main_task/src/test/resources/creating_test_info.txt";
        Files.write(Paths.get(output), Collections.singleton(DirectoryReader.output));

        BufferedReader br = Files.newBufferedReader(Paths.get(output));
        List<String> listOfStrings = br.lines().collect(Collectors.toList());

       br = Files.newBufferedReader(Paths.get("main_task/src/test/resources/test_info.txt"));
       List<String> testListOfStrings = br.lines().collect(Collectors.toList());

       assertEquals(listOfStrings, testListOfStrings);
    }
}
