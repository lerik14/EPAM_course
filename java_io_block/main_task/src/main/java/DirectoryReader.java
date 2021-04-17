import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryReader {

    static String output = "";
    static String prefix = "|";
    static String filePrefix = "--";
    static String directoryPrefix = "|--";

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        Path path;
        int level = 0;

        MyFileVisitor(Path path) {
            this.path = path;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            output = output + prefix + indentation(level) + filePrefix + path.getFileName() + "\n";
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
            output = output + prefix + indentation(level) + directoryPrefix + path.getFileName() + "\n";
            level++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path path, IOException exc) {
            level--;
            return FileVisitResult.CONTINUE;
        }

        public String indentation(int level) {
            String output = "";
            for (int i = 0; i < level; i++) {
                output = output + " ";
            }
            return output;
        }
    }
}
