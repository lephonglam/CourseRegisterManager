package example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private List<Student> students;
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
        }
    }

    @Override
    public String toString() {
        return id + " " + name + "      gv: " + teacher.getName();
    }
}
