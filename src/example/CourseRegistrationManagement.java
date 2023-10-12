package example;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationManagement implements Management{
    private List<Student> students;
    private List<Course> courses;
    private List<Teacher> teachers;

    public CourseRegistrationManagement() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void addCourse(Course course) {
        course.setId(courses.size() + 1);
        courses.add(course);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacher.setId(teachers.size() + 1);
        teachers.add(teacher);
    }

    @Override
    public void registerCourse(Student student, Course course) {
        if(student.getCourses().contains(course)){
            System.out.println("Course has registered before!");
            return;
        }
        student.getCourses().add(course);
        if(!student.getTeachers().contains(course.getTeacher())){
            student.getTeachers().add(course.getTeacher());
        }

        course.getStudents().add(student);

        if(!course.getTeacher().getStudents().contains(student)){
            course.getTeacher().getStudents().add(student);
        }
    }
}
