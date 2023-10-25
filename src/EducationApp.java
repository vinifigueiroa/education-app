import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EducationApp {
    public static void main(String[] args) {

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

        JButton viewStudentDetails = new JButton("View Students Details");
        mainPanel.add(viewStudentDetails);

        JButton assignGrade = new JButton("Assign Grades");
        mainPanel.add(assignGrade);


        // Courses Section
        JButton enrollStudent = new JButton("Enroll Student in a Course");
        mainPanel.add(enrollStudent);

        JButton addCourse = new JButton("Add a new Course");
        mainPanel.add(addCourse);

        JButton viewCourses = new JButton("List All Courses");
        mainPanel.add(viewCourses);




        // Display Frame
        mainFrame.setVisible(true);
    }
}
