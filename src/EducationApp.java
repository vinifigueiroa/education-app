import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EducationApp {
    public static void main(String[] args) {

        //Load Default Courses
        {
            new Course("CS101", "Introduction to Programming", 30);
            new Course("MATH202", "Calculus II", 40);
            new Course("ENG301", "Advanced English Composition", 25);
            new Course("BIO201", "Biology Concepts", 35);
            new Course("PHYS101", "Physics Fundamentals", 28);
            new Course("CHEM202", "Chemistry Lab", 45);
            new Course("HIST101", "World History", 30);
            new Course("ART203", "Art Appreciation", 20);
            new Course("PSYCH202", "Psychology 202", 40);
            new Course("ECON301", "Economic Principles", 50);
        }

        // Load Default Students
        {
            new Student("John Smith", 22);
            new Student("Alice Johnson", 20);
            new Student("David Lee", 25);
            new Student("Emily Davis", 21);
            new Student("Michael Wilson", 23);
            new Student("Sophia Brown", 30);
            new Student("James Anderson", 40);
            new Student("Olivia Garcia", 20);
            new Student("William Martinez", 18);
            new Student("Emma Rodriguez", 32);
        }

        // Enroll default Students
        {
            (Student.getByID(101)).enrollInCourse(Course.getByCode("CS101"));
            (Student.getByID(102)).enrollInCourse(Course.getByCode("MATH202"));
            (Student.getByID(103)).enrollInCourse(Course.getByCode("ENG301"));
            (Student.getByID(104)).enrollInCourse(Course.getByCode("BIO201"));
            (Student.getByID(105)).enrollInCourse(Course.getByCode("PHYS101"));
            (Student.getByID(106)).enrollInCourse(Course.getByCode("CHEM202"));
            (Student.getByID(107)).enrollInCourse(Course.getByCode("HIST101"));
            (Student.getByID(108)).enrollInCourse(Course.getByCode("ART203"));
            (Student.getByID(109)).enrollInCourse(Course.getByCode("PSYCH202"));
            (Student.getByID(101)).enrollInCourse(Course.getByCode("ECON301"));
            (Student.getByID(101)).enrollInCourse(Course.getByCode("MATH202"));
            (Student.getByID(102)).enrollInCourse(Course.getByCode("ENG301"));
            (Student.getByID(103)).enrollInCourse(Course.getByCode("BIO201"));
            (Student.getByID(104)).enrollInCourse(Course.getByCode("PHYS101"));
            (Student.getByID(105)).enrollInCourse(Course.getByCode("CHEM202"));
            (Student.getByID(106)).enrollInCourse(Course.getByCode("HIST101"));
            (Student.getByID(107)).enrollInCourse(Course.getByCode("ART203"));
            (Student.getByID(108)).enrollInCourse(Course.getByCode("PSYCH202"));
            (Student.getByID(109)).enrollInCourse(Course.getByCode("ECON301"));
            (Student.getByID(101)).enrollInCourse(Course.getByCode("MATH202"));

        }

        // Main Frame
        JFrame mainFrame = new JFrame("Education App");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 500);
        mainFrame.getContentPane().setBackground(Color.ORANGE);


        // Main Panel
        JPanel mainPanel = new JPanel();
        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainFrame.add(mainPanel);


        // Header
        JLabel mainTitle = new JLabel("Student Management Portal");
        mainPanel.add(mainTitle);
        // mainPanel.add(new JLabel("Select an Option Below"));


        // Student Section

        // Add new Student
        JButton addNewStudent = new JButton("Add New Student");
        mainPanel.add(addNewStudent);
        addNewStudent.addActionListener(new openAddNewStudentFormAction());

        // Update Student
        JButton updateStudent = new JButton("Update Student's Information");
        mainPanel.add(updateStudent);

        // List All Students
        JButton listAllStudents = new JButton("List All Students");
        mainPanel.add(listAllStudents);
        listAllStudents.addActionListener(new ListStudentsAction());

        // Assign Grade
        JButton assignGrade = new JButton("Assign Grades");
        mainPanel.add(assignGrade);


        // Courses Section
        JButton enrollStudent = new JButton("Enroll Student in a Course");
        mainPanel.add(enrollStudent);
        enrollStudent.addActionListener(new openEnrollStudentFormAction());

        JButton addCourse = new JButton("Add a new Course");
        mainPanel.add(addCourse);
        addCourse.addActionListener(new openAddNewCourseFormAction());

        JButton viewCourses = new JButton("List All Courses");
        mainPanel.add(viewCourses);
        viewCourses.addActionListener(new ListCoursesAction());

        // Display Frame
        mainFrame.setVisible(true);
    }

    private static void displayAddNewStudentForm() {

        JFrame addNewStudentForm = new JFrame("Add New Student");
        addNewStudentForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addNewStudentForm.setSize(300, 300);

        JPanel addNewStudentPanel = new JPanel();
        addNewStudentForm.add(addNewStudentPanel);

        JLabel studentNameLabel = new JLabel("Student Name:");
        addNewStudentPanel.add(studentNameLabel);
        JTextField studentNameField = new JTextField("First and Last name");
        addNewStudentPanel.add(studentNameField);

        JLabel studentAgeLabel = new JLabel("Student Age:");
        addNewStudentPanel.add(studentAgeLabel);
        JTextField studentAgeField = new JTextField("Age in Years (Numbers)");
        addNewStudentPanel.add(studentAgeField);

        JButton confirmAddStudent = new JButton("Add Student");
        addNewStudentPanel.add(confirmAddStudent);
        confirmAddStudent.addActionListener(e -> {

            String ageString = studentAgeField.getText();

            if (!Helpers.positiveIntegerCheck(ageString) || ageString.isEmpty()) {

                JOptionPane.showOptionDialog(null, "The age fiel should contain a number greater than zero", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;
            }

            int age = Integer.parseInt(ageString);

            String name = studentNameField.getText();

            if (name.isEmpty()) {

                JOptionPane.showOptionDialog(null, "Student name can't be empty", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;
            }

            Student student = new Student(name, age);
            JOptionPane.showOptionDialog(null, "Student Added: \n" + student.toString(), "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
            addNewStudentForm.setVisible(false);

        });

        addNewStudentForm.setVisible(true);
    }

    private static void displayAddNewCourseForm() {

        JFrame addNewCourseForm = new JFrame("Add New Course");
        addNewCourseForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addNewCourseForm.setSize(300, 300);

        JPanel addNewCoursePanel = new JPanel();
        // addNewCoursePanel.setLayout(new GridLayout(1, 1));
        addNewCourseForm.add(addNewCoursePanel);

        JLabel courseCodeLabel = new JLabel("Course Code:");
        addNewCoursePanel.add(courseCodeLabel);
        JTextField courseCodeField = new JTextField("ABC1234");
        addNewCoursePanel.add(courseCodeField);

        JLabel courseNameLabel = new JLabel("Course Name:");
        addNewCoursePanel.add(courseNameLabel);
        JTextField courseNameField = new JTextField("Full Course Name");
        addNewCoursePanel.add(courseNameField);

        JLabel courseCapacityLabel = new JLabel("Course Capacity:");
        addNewCoursePanel.add(courseCapacityLabel);
        JTextField courseCapacityField = new JTextField("Maximum Capacity (Number)");
        addNewCoursePanel.add(courseCapacityField);

        JButton confirmAddCourse = new JButton("Add Course");
        addNewCoursePanel.add(confirmAddCourse);
        confirmAddCourse.addActionListener(e -> {

            String code = courseCodeField.getText();
            String name = courseNameField.getText();
            String capacity = courseCapacityField.getText();

            if (!Helpers.positiveIntegerCheck(capacity)|| capacity.isEmpty()) {

                JOptionPane.showOptionDialog(null, "The capacity field should contain a number greater than zero", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;
            }

            if ((Course.getAllCoursesCodes()).contains(code)) {

                JOptionPane.showOptionDialog(null, "This course code already exists", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;
            }

            if (code.isEmpty()) {

                JOptionPane.showOptionDialog(null, "Course code field can't be empty", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;

            }

            if (name.isEmpty()) {

                JOptionPane.showOptionDialog(null, "Course name field can't be empty", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;

            }

            Course course = new Course(code, name, Integer.parseInt(capacity));
            JOptionPane.showOptionDialog(null, "Course Added: \n" + course.toString(), "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
            addNewCourseForm.setVisible(false);

        });


        addNewCourseForm.setVisible(true);
    }

    private static void displayEnrollStudentForm() {

        JFrame enrollStudentForm = new JFrame("Enroll Student");
        enrollStudentForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        enrollStudentForm.setSize(600, 400);


        JPanel enrollStudentPanel = new JPanel();
        // addNewCoursePanel.setLayout(new GridLayout(1, 1));
        enrollStudentForm.add(enrollStudentPanel);

        JLabel selectStudentLabel = new JLabel("Select A Student:");
        enrollStudentPanel.add(selectStudentLabel);

        JComboBox<Student> studentOptions = new JComboBox<>(Student.getAllStudents());
        enrollStudentPanel.add(studentOptions);

        JTextArea enrolledCoursesArea = new JTextArea();
        enrolledCoursesArea.setBackground(null);


        studentOptions.addActionListener(e -> {

            Student student = (Student) studentOptions.getSelectedItem();
            enrollStudentPanel.add(enrolledCoursesArea);
            enrolledCoursesArea.setText(student.listEnrolledCourses());
            enrollStudentPanel.revalidate();
            enrollStudentPanel.repaint();

        });

        JLabel selectCourseLabel = new JLabel("Select A Course to Enroll the Student:");
        enrollStudentPanel.add(selectCourseLabel);

        JComboBox<Course> courseOptions = new JComboBox<>(Course.getAllCourses());
        enrollStudentPanel.add(courseOptions);

        JButton confirmEnroll = new JButton("Enroll in This Course");
        enrollStudentPanel.add(confirmEnroll);
        confirmEnroll.addActionListener(e -> {

            Student student = (Student) studentOptions.getSelectedItem();
            Course course = (Course) courseOptions.getSelectedItem();

            if (student.IsEnrolled(course)) {

                JOptionPane.showOptionDialog(null, "Studented is already enrolled in this course", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;
            }

            student.enrollInCourse(course);
            JOptionPane.showOptionDialog(null, student.getName() + " Successfully Enrolled in " + course.getCourseName(), "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
            enrollStudentForm.setVisible(false);

        });

        enrollStudentForm.setVisible(true);
    }

    static class ListStudentsAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JOptionPane.showOptionDialog(null, Student.stringListAllStudents(), "All Students", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
        }
    }

    static class ListCoursesAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JOptionPane.showOptionDialog(null, Course.listAllCourses(), "All Courses", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
        }
    }

    static class openAddNewStudentFormAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            displayAddNewStudentForm();
        }
    }

    static class openAddNewCourseFormAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            displayAddNewCourseForm();
        }
    }

    static class openEnrollStudentFormAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            displayEnrollStudentForm();
        }
    }
}
