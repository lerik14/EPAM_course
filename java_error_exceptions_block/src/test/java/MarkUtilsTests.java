import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MarkUtilsTests {

    private Faculty informaticsFaculty;
    private List<StudyClass> classesForGroup12;
    private List<StudyClass> classesForGroup34;
    private Group group12;
    private Group group34;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    @Before
    public void initializeTestData() {
        Faculty.listOfFaculties = new ArrayList<>();
        Student.listOfStudents = new ArrayList<>();
        informaticsFaculty = new Faculty("Faculty of Informatics");
        classesForGroup12 = asList(StudyClass.MATH, StudyClass.INFORMATICS, StudyClass.ENGLISH);
        classesForGroup34 = asList(StudyClass.MATH, StudyClass.ASTROLOGY);

        group12 = new Group(12, informaticsFaculty, classesForGroup12);
        group34 = new Group(34, informaticsFaculty, classesForGroup34);

        student1 = new Student(1, "Ivan", group12);
        student2 = new Student(2, "Petr", group12);
        student3 = new Student(3, "Igor", group34);
        student4 = new Student(4, "Kirill", group34);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNegativeMarkExceptionTest() {
        student1.addMark(StudyClass.MATH, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPositiveMarkExceptionTest() {
        student1.addMark(StudyClass.MATH, 99);
    }

    @Test
    public void addExpectedMarkTest() {
        student1.addMark(StudyClass.MATH, 5);
        assertEquals(5, (int) student1.listOfMarks.get(StudyClass.MATH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMarkInAnotherCLassTest() {
        student1.addMark(StudyClass.ASTROLOGY, 5);
    }

    @Test //Student has 3 classes but only 2 ot them have mark
    public void averageStudentMarkInAllClassesTest() {
        student1.addMark(StudyClass.INFORMATICS, 7);
        student1.addMark(StudyClass.MATH, 10);
        assertEquals(8.5, MarkUtils.averageStudentMarkInAllClasses(student1), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void averageStudentMarkInAllClassesInCaseLackOfClassesTest() {
        List<StudyClass> classesForGroup56 = new ArrayList<>();
        Group group56 = new Group(34, informaticsFaculty, classesForGroup56);

        MarkUtils.averageStudentMarkInAllClasses(new Student(2, "Petr", group56));
    }

    @Test
    public void averageStudentMarkInAllClassesInCaseLackOfMarksTest() {
        assertEquals(0, MarkUtils.averageStudentMarkInAllClasses(student1), 0.001);
    }

    @Test //Two students in group but only one has mark
    public void averageClassMarkInGroupTest() {
        student1.addMark(StudyClass.MATH, 6);

        assertEquals(6, MarkUtils.averageClassMarkInGroup(StudyClass.MATH, group12), 0.001);
    }

    @Test(expected = IllegalArgumentException.class) //Group56 doesn't contain students
    public void averageClassMarkInGroupInCaseLackOfStudentsInGroupExceptionTest() {
        Group group56 = new Group(56, informaticsFaculty, classesForGroup12);

        MarkUtils.averageClassMarkInGroup(StudyClass.MATH, group56);
    }

    @Test(expected = IllegalArgumentException.class) //Group12 doesn't have class astrology
    public void averageClassMarkInGroupInCaseLackOfSpecifiedClassInGroupExceptionTest() {
        MarkUtils.averageClassMarkInGroup(StudyClass.ASTROLOGY, group12);
    }

    @Test
    public void averageClassMarkInGroupInCaseLackOfMarksInGroupTest() { //Group34 doesn't have student with mark in math class
        assertEquals(0, MarkUtils.averageClassMarkInGroup(StudyClass.MATH, group34), 0.001);
    }

    @Test
    public void averageClassMarkInFaculty() {
        student1.addMark(StudyClass.MATH, 7);
        student2.addMark(StudyClass.MATH, 5);
        student4.addMark(StudyClass.MATH, 3);
        assertEquals(5, MarkUtils.averageClassMarkInFaculty(StudyClass.MATH, informaticsFaculty), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void averageClassMarkInFacultyInCaseLackOfGroupsWithSpecifiedClassExceptionTest() {
        MarkUtils.averageClassMarkInFaculty(StudyClass.ECONOMY, informaticsFaculty);
    }

    @Test
    public void averageClassMarkInFacultyInCaseLackOfMarksTest() {
        assertEquals(0, MarkUtils.averageClassMarkInFaculty(StudyClass.MATH, informaticsFaculty), 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void averageMarkInAllUniversityInCaseLackOfFacultiesExceptionsTest() {
        Faculty.listOfFaculties = null;

        MarkUtils.averageMarkInAllUniversity(StudyClass.MATH);
    }

    @Test
    public void averageMarkInAllUniversityTest() {
        Faculty economicsFaculty = new Faculty("Faculty of Economics");
        List<StudyClass> classesForGroup56 = asList(StudyClass.MATH, StudyClass.ENGLISH);
        Group group56 = new Group(56, economicsFaculty, classesForGroup56);
        Student student5 = new Student(11, "Arsen", group56);

        student5.addMark(StudyClass.MATH, 8);
        student1.addMark(StudyClass.MATH,2);
        assertEquals(5, MarkUtils.averageMarkInAllUniversity(StudyClass.MATH), 0.001);
    }

    @Test
    public void checkNanTest() {
        String msg = "Input number was NaN";
        assertEquals(0, MarkUtils.checkNan(Double.NaN, msg), 0.001);
    }

    @Test
    public void checkNotNanTest() {
        String msg = "Input number was NaN";
        assertEquals(3.23, 3.23, 0.001);
    }
}
