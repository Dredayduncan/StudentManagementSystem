import java.util.ArrayList;

public class Student {

    // Set the required variables for a student
    private String name;
    private String sID;
    private String major;
    private String dob;
    private ArrayList<Course> courses;

    // initialize all the required variables
    public Student(String sName, String sID, String sMajor, String sDob) {
        this.name = sName;
        this.sID = sID;
        this.major = sMajor;
        this.dob = sDob;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getsID() {
        return sID;
    }

    public String getMajor() {
        return major;
    }

    public String getDob() {
        return dob;
    }

    public ArrayList<Course> getCourses() { return courses; }

    public void setName(String name) {
        this.name = name;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // Add a course that the student is taking
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Remove a course that the student is taking
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // Show all the courses the user has enrolled in
    public String showCourses() {
        if (courses.isEmpty()){
            return "You have not enrolled into any course.";
        }
        else{
            String courseDetails = "";
            for (Course course: courses){
                courseDetails += course.getName() + ", ";
            }

            return courseDetails;
        }
    }

    @Override
    public String toString() {
        return
                "{name='" + name + '\'' +
                ", sID='" + sID + '\'' +
                ", major='" + major + '\'' +
                ", dob='" + dob + '\'' +
                ", courses=" + showCourses() +
                '}';
    }
}