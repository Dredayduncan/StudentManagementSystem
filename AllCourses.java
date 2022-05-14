import java.util.Hashtable;
import java.util.Set;

public class AllCourses {
    private Hashtable<String, Course> courses;

    public AllCourses(Hashtable<String, Course> courses) {
        this.courses = courses;
    }

    //    public AllCourses(){}

    // Add a course to the hashtable
    public void  addCourse(String name, Course course){
        courses.put(name, course);
    }

    // Get course
    public Course getCourse(String name){
        return courses.get(name);
    }

    // Show Courses
    public void showCourses(){
        // Get all the keys in the hashtable
        Set<String> setOfKeys = courses.keySet();

        for (String key: setOfKeys){
            Course course = courses.get(key);

            // Get the course details
            String courseDetails = course.getName()
                    + "\n Cohort A : " +  course.getCohortA().getTeacher().getName()
                    + "\n Capacity : " + course.getCohortA().getClassSize() + " / " + course.getCohortA().getCapacity()
                    + "\n Cohort B : " +  course.getCohortB().getTeacher().getName()
                    + "\n Capacity : " + course.getCohortB().getClassSize() + " / " + course.getCohortB().getCapacity();

            // Print the details
            System.out.println(courseDetails);
        }
    }

    // Enroll into the stated cohort of the selected course
    public boolean enrollIntoCourse(String name, Student student, String cohort){
        if (student.getCourses().size() > 3) {
            System.out.println("You have reached your course limit.");
            return false;
        }
        System.out.println(cohort);
        // Adds course to list of student's enrolled courses
        if (cohort.equals("A")){
            student.addCourse(courses.get(name));
            return courses.get(name).enrollIntoCohortA(student);
        }
        else if (cohort.equals("B")){
            student.addCourse(courses.get(name));
            return courses.get(name).enrollIntoCohortB(student);
        }
        else{
            return false;
        }
    }
}
