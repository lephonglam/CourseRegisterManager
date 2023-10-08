package example;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private int id;
    private String address;
    private String phone;

    private String term;

    private List<Course> courses;

    public Student(String name, int age, String sex, int id, String address, String phone, String term) {
        super(name, age, sex);
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.term = term;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
