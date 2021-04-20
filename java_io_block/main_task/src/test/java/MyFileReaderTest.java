import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MyFileReaderTest {

    BufferedReader br = Files.newBufferedReader(Paths.get("main_task/src/test/resources/test_info.txt"));
    List<String> listOfStrings = br.lines().collect(Collectors.toList());

    public MyFileReaderTest() throws IOException {
    }

    @Test
    public void countDirectoriesTest() {
        assertEquals(4, MyFileReader.countDirectories(listOfStrings));
    }

    @Test
    public void countFilesTest() {
        assertEquals(7, MyFileReader.countFiles(listOfStrings));
    }

    @Test
    public void averageFileNameSizeTest() {
        assertEquals(3.28, MyFileReader.averageFileNameSize(listOfStrings), 0.01);
    }

    @Test
    public void averageFilesAmountInDirTest() {
        assertEquals(1.75, MyFileReader.averageFilesAmountInDir(listOfStrings), 0.01);
    }

    @Test
    public void readFileTest() {
        assertEquals(listOfStrings, MyFileReader.readFile("main_task/src/test/resources/test_info.txt"));
    }
}
