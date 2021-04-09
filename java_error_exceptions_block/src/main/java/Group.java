import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupNumber;
    private Faculty faculty;
    public List<StudyClass> listOfClasses;
    public static List<Group> listOfGroups = new ArrayList<>();

    public Group(int groupNumber, Faculty faculty, List<StudyClass> listOfClasses) {
        this.faculty = faculty;
        this.groupNumber = groupNumber;
        this.listOfClasses = listOfClasses;
        listOfGroups.add(this);
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<StudyClass> getListOfClasses() {
        return listOfClasses;
    }

    @Override
    public String toString() {
        return "group number=" + groupNumber +
                ", faculty=" + faculty.getName();
    }
}
