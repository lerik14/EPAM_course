import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MarkUtils {

    /**
     * Task: Посчитать средний балл по всем предметам студента
     * @param student - Студент, чей средний баз по всем предметам необходимо посчитать
     * @return Средняя оценка студента по всем предметам
     */
    public static double averageStudentMarkInAllClasses(Student student) {
        if (!student.listOfMarks.keySet().isEmpty()) {
            int sum = 0;
            int numberOfMarks = 0;
            for (Map.Entry<StudyClass, Integer> entry : student.listOfMarks.entrySet()) {
                try {
                    sum += entry.getValue();
                    numberOfMarks++;
                } catch (NullPointerException e) {
                    System.out.println(student.getName() + " doesn't have mark in class " + entry.getKey());
                }
            }
            String msg = student.getName() + " doesn't have marks in all classes";
            double averageMark = (double) sum / numberOfMarks;
            return checkNan(averageMark, msg);
        } else {
            throw new IllegalArgumentException(student.getName() + " doesn't have classes");
        }
    }

    /**
     * Task: Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
     * Так как в архитектуре программы не может одна группа приналдежать разным факультетам, данная задача была разбита на две -
     * посчитать средний балл по конкретному предмету в конкретной группе
     * и средний балл по конкретному предмету на конктерном факультете.
     * @param studyClass - предмет, по которому необходимо посчитать среднюю оценку в группе;
     * @param group - группа, чью среднюю оценку по предмету необходимо посчитать;
     * @return среднее значение оценки по указанному предмету в указанной группе;
     */
    public static double averageClassMarkInGroup(StudyClass studyClass, Group group) {
        if (group.listOfClasses.contains(studyClass)) {
            List<Student> list = Student.listOfStudents.stream().
                    filter(student -> student.getGroup().equals(group)).collect(Collectors.toList());
            if (!list.isEmpty()) {
                double averageMark = countAverageMarkInTheListForTheClass(list, studyClass);
                String msg = "There is no student who has mark in class " + studyClass + " and study in a " + group;
                return checkNan(averageMark, msg);
            } else {
                throw new IllegalArgumentException(group +"  doesn't contain students");
            }
        } else {
            throw new IllegalArgumentException("This group " + group + " doesn't have specified class " + studyClass);
        }
    }

    /**
     * Task: Посчитать средний балл по конкретному предмету на конкретном факультете
     * @param studyClass - предмет, по которому необходимо посчитать среднюю оценку в группе;
     * @param faculty - факультет, на котором необходимо посчитать среднюю оценку по указанному предмету;
     * @return среднее значение оценки по указанному предмету на указанном факультете;
     */
    public static double averageClassMarkInFaculty(StudyClass studyClass, Faculty faculty) {
        if (Student.listOfStudents.stream().anyMatch(st -> st.listOfMarks.containsKey(studyClass)
                && st.getGroup().getFaculty().equals(faculty)))  {
            List<Student> list = Student.listOfStudents.stream().filter(student -> student.listOfMarks.containsKey(studyClass)
                    && student.getGroup().getFaculty().equals(faculty)).collect(Collectors.toList());
            double averageMark = countAverageMarkInTheListForTheClass(list, studyClass);
            String msg = "There is no student who has mark in class " + studyClass + " and study at the " + faculty;
            return checkNan(averageMark, msg);
            } else {
            throw new IllegalArgumentException("There is no group at the " + faculty + " which study " + studyClass);
        }
    }

    /**
     * Task: Посчитать средний балл по предмету для всего университета;
     * @param studyClass - предмет, по которому необходимо посчитать средний бал в университете;
     * @return среднее значение оценки по указанному предмету во всем университете;
     */
    public static double averageMarkInAllUniversity(StudyClass studyClass) {
        if (!Faculty.listOfFaculties.isEmpty()) {
            List<Student> list = Student.listOfStudents.stream()
                    .filter(student -> student.listOfMarks.containsKey(studyClass)).collect(Collectors.toList());
            double averageMark = countAverageMarkInTheListForTheClass(list, studyClass);
            String msg = "There is no specified class " + studyClass + " in the University";
            return checkNan(averageMark, msg);
        } else {
            throw new NullPointerException("There is no faculty in the University");
        }
    }

    /**
     * Считает среднюю оценку по предмету в списке студентов;
     * @param listOfStudents - список студентов;
     * @param studyClass - предмет, по которому необходимо посчитать среднюю оценку;
     * @return среднее значение по предмету в переданном списке студентов;
     */
    public static double countAverageMarkInTheListForTheClass(List<Student> listOfStudents, StudyClass studyClass) {
        int sum = 0;
        int numberOfMarks = 0;
        for (Student student : listOfStudents) {
            try {
                sum += student.listOfMarks.get(studyClass);
                numberOfMarks ++;
            } catch (NullPointerException e) {
                System.out.println(student.getName() + " doesn't have mark in class " + studyClass + " so this student was excluded");
            }
        }
        return (double) sum / numberOfMarks;
    }

    /**
     * Проверяет является ли передаваемый параметр NaN и выводит сообщение в таком случае.
     * @param averageMark - параметр, который необходимо проверить являкется ли он NaN;
     * @param message - сообщение, которые выводится в случае, если передаваемый параметр является NaN;
     * @return передаваемый параметр, если он не NaN или сообщение в противном случае;
     */
    public static double checkNan(double averageMark, String message) {
        if (!Double.isNaN(averageMark)) {
            return averageMark;
        } else {
            System.out.println(message);
            return 0;
        }
    }
}
