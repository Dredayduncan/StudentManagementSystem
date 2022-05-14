import java.util.ArrayList;

public class Cohort {

    // Get the necessary variables for the cohort
    private Teacher teacher;
    ArrayList<Student> students;
    private int capacity = 10;

    public Cohort(){
        teacher = null;
        students = new ArrayList<>();
    }

    // enroll a student to the class
    public Boolean addStudent(Student student){
        // Check if the class is full
        if (students.size() == capacity){
            System.out.println("The class is full.");
            return false;
        }

        // Add the student if there's space
        students.add(student);
        return true;
    }

    // Check if a student is in the class
    public Boolean isStudentInClass(Student student){
        // Check if the class is empty
        if (students.size() == 0)
            return false;

        // Search for the student
        for (Student stud: students){
            if (stud.getsID().equals(student.getsID())){
                return true;
            }
        }

        // The student has not been found
        return false;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getClassSize() {
        return this.students.size();
    }

    public int getCapacity(){
        return this.capacity;
    }

    // Print the students in the class
    public void showStudents(){
        for (Student student: students){
            System.out.println(student.getName());
        }
    }


}
