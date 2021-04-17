import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class MainTaskMain {
    public static void main(String[] args) throws IOException {
        // You should input the absolute path to dir or txt file
        //For example you can use java_io_block/main_task/data or java_io_block/main_task/input.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        if (input.contains(".txt")) {
            //work with file
            List<String> listOfStrings = MyFileReader.fileRead(input);
            System.out.println("The number of directories is " + MyFileReader.countDirectories(listOfStrings));
            System.out.println("The number of files is " + MyFileReader.countFiles(listOfStrings));
            System.out.println("The average number of files per directory is " + MyFileReader.averageFilesAmountInDir(listOfStrings));
            System.out.println("The Average length of file name is " + MyFileReader.averageFileNameSize(listOfStrings));
        } else {
            //work with directory
            Path directory = Paths.get(input);
            DirectoryReader.MyFileVisitor visitor = new DirectoryReader.MyFileVisitor(directory);
            Files.walkFileTree(directory, visitor);
            String output = "java_io_block/main_task/info.txt";
            try {
                Files.write(Paths.get(output), Collections.singleton(DirectoryReader.output));
                System.out.println("Information has been successfully written to the file");
            } catch (IOException e) {
                throw new IllegalStateException("Cannot write into file", e);
            }
        }
    }
}
