package example;

import java.util.Scanner;

public interface Management {
    void addStudent(Student student);
    void addCourse(Course course);
    void addTeacher(Teacher teacher);
    void registerCourse(Student student, Course course);
}
