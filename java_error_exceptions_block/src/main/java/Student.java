import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private String name;
    private int id;
    private Group group;
    public Map<StudyClass, Integer> listOfMarks = new HashMap<>();
    public static List<Student> listOfStudents = new ArrayList<>();

    public Student(int id, String name, Group group) {
        this.name = name;
        this.id = id;
        this.group = group;
        group.listOfClasses.forEach(cl -> listOfMarks.put(cl, null));
        listOfStudents.add(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    public Map<StudyClass, Integer> getListOfMarks() {
        return listOfMarks;
    }

    public void addMark(StudyClass className, int mark) {
        if (listOfMarks.containsKey(className)) {
            if (mark >= 0 && mark <=10) {
                listOfMarks.put(className, mark);
            } else {
                throw new IllegalArgumentException("Input mark should be between 0 and 10. Input mark is " + mark);
            }
        } else {
            throw new IllegalArgumentException("This student doesn't have specified class in his schedule");
        }
    }

    @Override
    public String toString() {
        return "name='" + name + ", group=" + group.getGroupNumber();
    }
}
