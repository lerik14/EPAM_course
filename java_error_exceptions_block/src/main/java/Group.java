import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupNumber;
    private Faculty faculty;
    public List<StudyClass> listOfClasses; // list of classes in the group
    public static List<Group> listOfGroups = new ArrayList<>(); //list of all groups in the University

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
