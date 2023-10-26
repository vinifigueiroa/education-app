import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {

    // Class Variables
    private static Map<Integer, Student> allStudents = new HashMap<>();
    private static int studentsCount = 0;


    // Instance Variables
    private String name;
    private int age;
    private int ID;
    private Map<Course, Integer> grades = new HashMap<>();


    // Constructor
    public Student(String name, int age) {

        this.name = name;
        this.age = age;
        this.ID = studentsCount + 101;

        allStudents.put(ID, this);
        studentsCount++;
    }


    // Getter Methods
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return "ID: " + ID +" | "+ name + " | Age: "+ age;
    }

    public int getOverallGrade(){

        int gradeSum = 0;
        int courseCount = 0;

        for (int grade : (this.grades).values()) {
            gradeSum += grade;
            courseCount++;
        }

        if (courseCount == 0) {
            return 0;
        }

        return gradeSum / courseCount;

    }

    public String listEnrolledCourses() {
        // List all courses a student is currently enrolled.

        StringBuilder courses = new StringBuilder("Currently Enrolled Courses:\n\n");

        for (Course course : grades.keySet()) {
            courses.append(course.toString()+ "\n");
        }

        return courses.toString();
    }

    public Course[] getEnrolledCourses() {

        Set<Course> keySet = grades.keySet();
        return keySet.toArray(new Course[0]);
    }

    public String getGrades() {
        // Lists the student's grades

        StringBuilder grades = new StringBuilder("Current Grades:\n\n");

        for (Map.Entry<Course, Integer> entry : this.grades.entrySet()) {
            grades.append(entry.getKey() + " || Grade: " + entry.getValue()+ "\n");
        }

        return grades.toString();
    }

    public Integer getGrade(Course course) {
        return grades.get(course);
    }

    public boolean IsEnrolled(Course course) {
        // Checks if a student is enrolled in a particular course

        if (this.grades.get(course) == null) {
            return false;
        }

        return true;
    }

    // Setter Methods
    public void setName(String newname) {
        name = newname;
    }

    // Class Interface

    public static Student getByID(int ID) {
        // Returns a student by its ID

        Student student = allStudents.get(ID);

        if (student == null) {
            throw new IllegalArgumentException("ID Not Found.");
        }

        return student;

    }

    public void enrollInCourse(Course course) {
        // Enrolls a student in a course;

        Map<Integer, Student> courseStudents = course.getEnrolledStudents();

        if (courseStudents.size() >= course.getCourseMaxCapacity()) {

            throw new IllegalArgumentException("This course is full.");
        }


        grades.put(course, 0);
        courseStudents.put(ID, this);

    }

    public void assignGrade(Course course, int grade) {
        // Assigns a grade to course the student is enrolled.

        if (!(course.getEnrolledStudents()).containsKey(this.ID)) {
            throw new IllegalArgumentException("Student is not enrolled.");
        }

        grades.put(course, grade);
    }

    public static void getAllGrades() {
        // Displays all average grades from all students.

        for (Student student : allStudents.values()) {
            System.out.println(student.name + ": " + student.getOverallGrade());
        }
    }

    public static String stringListAllStudents() {

        StringBuilder studentList = new StringBuilder("List of Students:\n\n");

        for (Student student : allStudents.values()) {
            studentList.append(student.toString()+ "\n");
        }

        return studentList.toString();
    }

    public static ArrayList<String> arrayListAllStudents() {

        ArrayList<String> studentList = new ArrayList<>();

        for (Student student : allStudents.values()) {
            studentList.add(student.toString());
        }

        return studentList;
    }

    public static Student[] getAllStudents() {

        return allStudents.values().toArray(new Student[0]);
    }
}
