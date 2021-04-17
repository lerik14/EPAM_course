import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyFileReader {

    /**
     * Try to read file and write all file strings into the list
     * @param path - absolute path to the txt file
     * @return list of file strings
     */
    public static List<String> fileRead(String path) {
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(path));
            return br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public static int countDirectories(List<String> listOfLines) {
        int numOfDirs = 0;
        for (String line : listOfLines) {
            if (line.contains(DirectoryReader.directoryPrefix)) {
                numOfDirs++;
            }
        }
        return numOfDirs;
    }

    public static int countFiles(List<String> listOfLines) {
        int numOfFiles = 0;
        for (String line : listOfLines) {
            if (line.contains(DirectoryReader.filePrefix) && !line.contains(DirectoryReader.directoryPrefix)) {
                numOfFiles++;
            }
        }
        return numOfFiles;
    }

    public static double averageFilesAmountInDir(List<String> listOfLines) {
        List<Integer> numberOfFilesInDir = new ArrayList<>();
        for (int i = 0; i < listOfLines.size(); i++) {
            if (listOfLines.get(i).contains(DirectoryReader.directoryPrefix)) {
                List<String> sublist = listOfLines.subList(i, listOfLines.size());
                numberOfFilesInDir.add(countFilesInDir(sublist));
            }
        }
        int numOfDirs = numberOfFilesInDir.size(); // get number of directories
        int numOfFiles = 0;
        for (Integer elem : numberOfFilesInDir) {
            numOfFiles += elem;
        }
        return (double) numOfFiles / numOfDirs;
    }

    public static double averageFileNameSize(List<String> listOfLines) {
        int numOfLines = 0;
        int numOfElems = 0;
        for (String line : listOfLines) {
            if (line.contains(DirectoryReader.filePrefix) && !line.contains(DirectoryReader.directoryPrefix)) {
                Pattern pattern = Pattern.compile("--(.+?)(\\.[^.]*$|$)");// find only file's name without extension
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    numOfElems += matcher.group(1).length();
                    numOfLines++;
                }
            }
        }
        return (double) numOfElems / numOfLines;
    }

    /**
     * Count the number of files per directory
     * @param listOfLines - list of file strings
     * @return number of files per directory
     */
    public static int countFilesInDir(List<String> listOfLines) {
        int numOfFiles = 0;
        int indent = countIndent(listOfLines.get(0));
        for (int j = 1; j < listOfLines.size(); j++) {
            if (countIndent(listOfLines.get(j)) == indent) {
                if (!listOfLines.get(j).contains(DirectoryReader.directoryPrefix)) {
                    numOfFiles++;
                } else {
                    break;
                }
            }
        }
        return numOfFiles;
    }

    /**
     * Count the number of symbols between first | and - for line
     * @param line - input line
     * @return number of symbols between first | and - for line
     */
    public static int countIndent(String line) {
        int indent = 0;
        Pattern pattern = Pattern.compile("^\\|(.*)--"); //find symbols between first | and -
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            indent = matcher.group(1).length();
        }
        return indent;
    }
}
