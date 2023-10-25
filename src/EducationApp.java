import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
            new Student("John Smith");
            new Student("Alice Johnson");
            new Student("David Lee");
            new Student("Emily Davis");
            new Student("Michael Wilson");
            new Student("Sophia Brown");
            new Student("James Anderson");
            new Student("Olivia Garcia");
            new Student("William Martinez");
            new Student("Emma Rodriguez");
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
        JButton addNewStudent = new JButton("Add New Student");
        mainPanel.add(addNewStudent);

        JButton updateStudent = new JButton("Update Student's Information");
        mainPanel.add(updateStudent);

        JButton listAllStudents = new JButton("List All Students");
        mainPanel.add(listAllStudents);
        listAllStudents.addActionListener(new ListStudentsAction());

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
}
