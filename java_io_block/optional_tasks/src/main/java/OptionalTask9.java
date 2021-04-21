import java.io.*;

import static org.apache.commons.lang3.RegExUtils.removeAll;

public class OptionalTask9 {
//    Из текста Java-программы удалить все виды комментариев.

    public static void task9() {
        String readFileName = "java_io_block/optional_tasks/data/javaFileForTask9.java";
        String writeFileName = "java_io_block/optional_tasks/data/output_javaFileForTask9.java";
        deleteCommentsInFile(readFileName, writeFileName);
    }

    public static void deleteCommentsInFile(String readFileName, String writeFileName) {
        try (FileReader readFile = new FileReader(readFileName);
             FileWriter writeFile = new FileWriter(writeFileName)) {
            StringBuilder contentBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(readFile);

            reader.lines().forEach(s -> contentBuilder.append(s).append("\n"));
            String newFileContent = removeAll(removeAll(contentBuilder.toString(), "\\/\\/.*?(?=\\n)"), "\\/\\*[\\W\\w]*\\*\\/");
            writeFile.write(newFileContent);
        } catch (IOException e) {
            throw new IllegalStateException("Files handling problem", e);
        }
    }
}
