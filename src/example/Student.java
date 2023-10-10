package example;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String id;
    private String address;
    private String phone;

    private int term;

    private List<Course> courses;

    private List<Teacher> teachers;

    public Student(String id, String name, int age, String sex, String address, String phone, int term) {
        super(name, age, sex);
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.term = term;
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public void addCourse(Course course){
        if(!courses.contains(course)){
            courses.add(course);
        }
    }
}