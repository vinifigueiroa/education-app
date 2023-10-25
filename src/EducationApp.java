import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

        JButton addCourse = new JButton("Add a new Course");
        mainPanel.add(addCourse);

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

            String name = studentNameField.getText();
            int age;

            if (!Helpers.positiveIntegerConvert(studentAgeField.getText())) {

                JOptionPane.showOptionDialog(null, "The age should only contain numbers greater than zero", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, e);
                return;
            }
            age = Integer.parseInt(studentAgeField.getText());
            Student student = new Student(name, age);
            JOptionPane.showOptionDialog(null, "Student Added: \n" + student.toString(), "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
            addNewStudentForm.setVisible(false);

        });

        addNewStudentForm.setVisible(true);
    }

    static class ListStudentsAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JOptionPane.showOptionDialog(null, Student.listAllStudents(), "All Students", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, e);
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
}
