import java.util.Arrays;
import java.util.List;

public class ExceptionsMainTaskMain {
    public static void main(String[] args) {

//        Throws exception because There is no faculty in the University
//        System.out.println(MarkUtils.averageMarkInAllUniversity(StudyClass.MATH));

        Faculty informaticsFaculty = new Faculty("Faculty of Informatics");
        Faculty economicsFaculty = new Faculty("Faculty of Economics");


        List<StudyClass> classesForGroup12 = Arrays.asList(StudyClass.MATH, StudyClass.INFORMATICS);
        List<StudyClass> classesForGroup34 = Arrays.asList(StudyClass.MATH, StudyClass.ENGLISH);
        List<StudyClass> classesForGroup56 = Arrays.asList(StudyClass.MATH, StudyClass.ECONOMY);

        Group group12 = new Group(12, informaticsFaculty, classesForGroup12);
        Group group34 = new Group(34, informaticsFaculty, classesForGroup34);
        Group group56 = new Group(56, economicsFaculty,classesForGroup56);

        Student ivanov = new Student(1, "Ivanov Petr", group12);
        Student petrov = new Student(2, "Petrov Sergey", group12);
        Student zhukov = new Student(3, "Zhukov Igor", group34);
        Student sidorov = new Student(4, "Sidorov Alex", group34);
        Student lebed = new Student(5, "Lebed Pavel", group56);

        ivanov.addMark(StudyClass.MATH, 6);
        sidorov.addMark(StudyClass.MATH, 5);
        zhukov.addMark(StudyClass.MATH, 9);
        petrov.addMark(StudyClass.MATH, 3);
        lebed.addMark(StudyClass.MATH, 5);

        System.out.println(MarkUtils.averageClassMarkInGroup(StudyClass.MATH, group12));
        System.out.println(MarkUtils.averageClassMarkInFaculty(StudyClass.MATH, informaticsFaculty));
        System.out.println(MarkUtils.averageMarkInAllUniversity(StudyClass.MATH));


    }
}
