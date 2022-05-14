import java.util.Hashtable;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        // Create Scanner object to handle input
        Scanner input = new Scanner(System.in);

        // Create Students
        Student student1 = new Student("Laura", "43152024", "CS", "18/03/2004");
        Student student2 = new Student("Eric", "12342024", "BA", "18/05/2001");
        Student student3 = new Student("Blade", "94832024", "MIS", "20/03/2002");
        Student student4 = new Student("John", "41252024", "ENG", "03/03/2000");
        Student student5 = new Student("Ciara", "03842024", "CS", "08/03/2000");

        // Instantiate Management object
        ManagementSystem mgmt = new ManagementSystem();
        mgmt.addStudent(student1);
        mgmt.addStudent(student2);
        mgmt.addStudent(student3);
        mgmt.addStudent(student4);
        mgmt.addStudent(student5);
        // Create sample teachers
        Teacher teacher1 = new Teacher("Joseph Mensah");
        Teacher teacher2 = new Teacher("Ayorkor Korsah");
        Teacher teacher3 = new Teacher("Owusu Banahene Osei");
        Teacher teacher4 = new Teacher("Attlee Gamundani");
        Teacher teacher5 = new Teacher("David Sampah");

        // Create sample courses
        Course course1 = new Course("Calculus1", teacher1, teacher2 );
        Course course2 = new Course("Calculus2", teacher2, teacher3 );
        Course course3 = new Course("Statistics", teacher3, teacher4 );
        Course course4 = new Course("Ashesi Success", teacher4, teacher5 );
        Course course5 = new Course("FDE", teacher5, teacher1 );

        // Store them in the hashtable
        Hashtable<String, Course> allCourses = new Hashtable<>();
        allCourses.put(course1.getName(), course1);
        allCourses.put(course2.getName(), course2);
        allCourses.put(course3.getName(), course3);
        allCourses.put(course4.getName(), course4);
        allCourses.put(course5.getName(), course5);

        // Create the courses object
        AllCourses courses = new AllCourses(allCourses);

        // Start the main application
        System.out.println("Welcome to the Student Management System. ");

        // Give the user options
        String options = "What would you like to do? (Type the number) \n"
                + "1. View All Courses \n2. Enroll into Courses \n3. Add Student \n4. Remove Student \n5. View Students \n6. Exit";

        System.out.println(options);

        // Get the user's option and perform the respective task
        String userInput = input.nextLine();

        // Check if the user's input is 5, meaning 5
        while (!userInput.equals("6")){

            if (userInput.equals("1")){
                courses.showCourses();
            }
            else if (userInput.equals("2")){
                System.out.println("These are the current courses");
                courses.showCourses();
                System.out.println("These are the current students");
                mgmt.viewStudents();
                System.out.println("Enter the name of the course you want to enroll in, the id of student you want to enroll, and the cohort (A or B) separated by a comma without spaces.");
                String[] courseAndCohort = input.nextLine().split(",");

                courses.enrollIntoCourse(courseAndCohort[0], mgmt.getStudent(Integer.parseInt(courseAndCohort[1])), courseAndCohort[2]);

            }
            else if (userInput.equals("3")){
                System.out.println("\nKindly enter the following student details separated by " +
                        "a comma in the stated order (name, student ID, major, date of birth (dd/mm/yyyy)):");

                // Get the student's details from the input
                String[] studentDetails = input.nextLine().split(",");

                // Create a student object with the details
                Student student = new Student(studentDetails[0], studentDetails[1].strip(), studentDetails[2], studentDetails[3]);

                // Add the student to the system
                mgmt.addStudent(student);
            }
            else if (userInput.equals("4")){
                System.out.println("Input the ID of the student you want to remove");
                String studID = input.next();
                mgmt.deleteStudent(Integer.parseInt(studID));
            }
            else if (userInput.equals("5")){
                mgmt.viewStudents();
            }
            
            System.out.println(options);
            userInput = input.nextLine();
            
        }

    }
}
