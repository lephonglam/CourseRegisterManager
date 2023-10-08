package example;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private int id;
    private String address;
    private String phone;

    private List<Course> cources;

    public Teacher(String name, int age, String sex, int id, String address, String phone) {
        super(name, age, sex);
        this.id = id;
        this.address = address;
        this.phone = phone;
        cources = new ArrayList<>();
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

    public List<Course> getCources() {
        return cources;
    }

    public void setCources(List<Course> cources) {
        this.cources = cources;
    }

    public void addCourse(Course course){
        cources.add(course);
    }
}
