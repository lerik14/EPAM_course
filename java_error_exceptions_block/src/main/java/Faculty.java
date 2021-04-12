import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    public static List<Faculty> listOfFaculties = new ArrayList<>(); //list of all faculties in the university
    public Faculty(String name) {
        this.name = name;
        listOfFaculties.add(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
