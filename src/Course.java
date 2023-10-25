import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Course {

    // Class Variables
    private static int totalEnrolledStudents = 0;
    private static Map<String, Course> allCourses = new HashMap<>();


    // Instance Variables
    private String courseCode;
    private String courseName;
    private int courseMaximumCapacity;
    private Map<Integer, Student> enrolledStudents = new HashMap<>();


    // Constructor
    public Course(String courseCode, String courseName, int courseMaximumCapacity) {

        if (allCourses.containsKey(courseCode)) {
            throw new IllegalArgumentException("This code already exists");
        }

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseMaximumCapacity = courseMaximumCapacity;

        allCourses.put(courseCode, this);

    }

    // Class Methods
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public static Set<String> getAllCoursesCodes() {
        return allCourses.keySet();
    }

    public static Course[] getAllCourses() {
        return allCourses.values().toArray(new Course[0]);
    }

    public static String listAllCourses() {

        StringBuilder list = new StringBuilder("All Courses:\n\n");

        for (Course course : allCourses.values()) {
            list.append(course.toString() + "\n");
        }

        return list.toString();
    }

    public static Course getByCode(String code) {
        // Retrieves a course by its course code.

        Course course = allCourses.get(code);

        if (course == null) {
            throw new IllegalArgumentException("Code Not Found.");
        }

        return course;
    }


    // Instance Getter Methods
    public String getCourseCode() {
        return this.courseCode;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getCourseMaxCapacity() {
        return this.courseMaximumCapacity;
    }

    public Map<Integer, Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public String toString() {
        return "Code: " + this.courseCode + " | " + this.courseName + " | Students Enrolled: " + (this.enrolledStudents).size() + "/" + this.courseMaximumCapacity;
    }


    // Instance Setter Methods
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseMaxCapacity(int courseMaxCapacity) {
        this.courseMaximumCapacity = courseMaxCapacity;
    }


}
