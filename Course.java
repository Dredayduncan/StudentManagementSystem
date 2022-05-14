public class Course {

    private String name;
    private Teacher teacher1;
    private Teacher teacher2;
    private Cohort cohortA;
    private Cohort cohortB;

    public Course(String name, Teacher teacher1, Teacher teacher2) {
        this.name = name;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.cohortA = new Cohort();
        this.cohortB = new Cohort();
        setTeachers();
    }

    private void setTeachers(){
        cohortA.setTeacher(this.teacher1);
        cohortB.setTeacher(this.teacher2);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Teacher getTeacher1() {return teacher1;}

    public void setTeacher1(Teacher teacher1) {
        this.teacher1 = teacher1;
        setTeachers(); // Update the teachers in the cohort
    }

    public Teacher getTeacher2() {return teacher2;}

    public void setTeacher2(Teacher teacher2) {
        this.teacher2 = teacher2;
        setTeachers(); // Update the teachers in the cohort
    }

    public Cohort getCohortA() {
        return cohortA;
    }

    public Cohort getCohortB() {
        return cohortB;
    }

    public boolean enrollIntoCohortA(Student student){
        return cohortA.addStudent(student);
    }

    public boolean enrollIntoCohortB(Student student){
        return cohortB.addStudent(student);
    }
}
