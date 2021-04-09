import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    public static List<Faculty> listOfFaculties = new ArrayList<>();
    public Faculty(String name) {
        this.name = name;
        listOfFaculties.add(this);
    }

    public String getName() {
        return name;
    }
}
