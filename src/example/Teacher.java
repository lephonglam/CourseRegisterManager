package example;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private int id;
    private String address;
    private String phone;

    private List<Student> students;

    private List<Course> courses;

    public Teacher(String name, int age, String sex, String address, String phone) {
        super(name, age, sex);
        this.address = address;
        this.phone = phone;
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
        }
    }

    public void addCourse(Course course){
        if(!courses.contains(course)){
            courses.add(course);
        }
    }
    @Override
    public String toString() {
        return id + " " + super.getName();
    }
}
