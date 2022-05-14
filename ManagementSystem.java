import java.util.Hashtable;
import java.util.Set;

public class ManagementSystem {
    Hashtable<Integer, Student> students;

    public ManagementSystem () {
        students = new Hashtable<>();
    }

    public void viewStudent(Integer studentID){
        System.out.println(students.get(studentID).toString());
    }

    public Student getStudent(Integer studentID){
        if (!students.containsKey(studentID)){
            return null;
        }

        return students.get(studentID);
    }

    public void addStudent(Student student){
        students.put(Integer.parseInt(student.getsID()), student);
    }

    public boolean deleteStudent(Integer studentID){
        if (!students.containsKey(studentID)){
            System.out.println("ID does not exist");
            return false;
        }

        students.remove(studentID);
        return true;
    }

    public void viewStudents(){
        // Get all the keys in the hashtable
        Set<Integer> setOfKeys = students.keySet();

        for (Integer key: setOfKeys){
            Student student = students.get(key);

            // Print the details
            System.out.println(student.toString());
        }
    }
}
