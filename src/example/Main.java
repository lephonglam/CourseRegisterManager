package example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Management MANAGE = new CourseRegistrationManagement();
    static Student enterStudent(){
        String id;
        do {
            System.out.print("Enter student's id: ");
            id = INPUT.next();
            INPUT.nextLine();
            CourseRegistrationManagement crm = (CourseRegistrationManagement) MANAGE;
            List<Student> students = crm.getStudents();
            if(!students.isEmpty()){
                for (Student student : students){
                    if(student.getId().equalsIgnoreCase(id)){
                        System.out.println("Student is existed!");
                        id = "";
                        break;
                    }
                }
            }
            if(id.trim().equals("")){
                System.out.println("Please enter student's id!");
            }
        }while(id.trim().equals(""));
        String name;
        do {
            System.out.print("Enter your name: ");
            name = INPUT.nextLine();
            if(name.trim().equals("")){
                System.out.println("Please enter your name!");
            }
        }while(name.trim().equals(""));

        int age = 0;
        do {
            try {
                System.out.print("Enter your age: ");
                age = INPUT.nextInt();
            }
            catch (Exception e){
                INPUT.nextLine();
                System.out.println("Please enter a digit!");
            }
            if(age <= 0){
                System.out.println("Please enter positive number!");
            }
        }while(age <= 0);

        String sex;
        do {
            System.out.print("Enter your sex (male or female): ");
            sex = INPUT.next();
            INPUT.nextLine();
            if(!sex.equals("male") && !sex.equals("female")){
                System.out.println("Please correctly enter your sex!");
            }
        }while(!sex.equals("male") && !sex.equals("female"));

        String address;
        do {
            System.out.print("Enter your address: ");
            address = INPUT.nextLine();
            if(address.trim().equals("")){
                System.out.println("Please enter your name!");
            }
        }while(address.trim().equals(""));

        String phone;
        do {
            System.out.print("Enter your phone: ");
            phone = INPUT.next();
            if(!phone.matches("\\d{10}")){
                System.out.println("Phone must have 10 numerals!");
            }
        }while(!phone.matches("\\d{10}"));

        int term = 0;
        do {
            try {
                System.out.print("Enter your term: ");
                term = INPUT.nextInt();
                INPUT.nextLine();
            }
            catch (Exception e){
                INPUT.nextLine();
                System.out.println("Please enter a digit!");
            }
            if(term <= 0){
                System.out.println("Please enter positive number!");
            }
        }while(term <= 0);

        return new Student(id, name, term, sex, address, phone, term);
    }

    static Teacher enterTeacher(){
        String name;
        do {
            System.out.print("Enter teacher's name: ");
            name = INPUT.nextLine();
            if(name.trim().equals("")){
                System.out.println("Please enter teacher's name!");
            }
        }while(name.trim().equals(""));

        int age = 0;
        do {
            try {
                System.out.print("Enter teacher's age: ");
                age = INPUT.nextInt();
            }
            catch (Exception e){
                age = 0;
                System.out.println("Please enter a digit!");
            }
            if(age <= 0){
                System.out.println("Please enter positive number!");
            }
        }while(age <= 0);

        String sex;
        do {
            System.out.print("Enter your sex (male or female): ");
            sex = INPUT.next();
            INPUT.nextLine();
            if(!sex.equals("male") && !sex.equals("female")){
                System.out.println("Please correctly enter your sex!");
            }
        }while(!sex.equals("male") && !sex.equals("female"));

        String address;
        do {
            System.out.print("Enter your address: ");
            address = INPUT.nextLine();
            if(address.trim().equals("")){
                System.out.println("Please enter your address!");
            }
        }while(address.trim().equals(""));

        String phone;
        do {
            System.out.print("Enter your phone: ");
            phone = INPUT.next();
            INPUT.nextLine();
            if(!phone.matches("\\d{10}")){
                System.out.println("Phone must have 10 numerals!");
            }
        }while(!phone.matches("\\d{10}"));
        return new Teacher(name, age, sex, address, phone);
    }

    public static void main(String[] args) {

        System.out.println("1. Add Student.");
        do{
            Student student = enterStudent();
            MANAGE.addStudent(student);
            String choice = "";
            do {
                System.out.print("Do you want to continue? (y/n): ");
                choice = INPUT.next();
                INPUT.nextLine();
                if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
                    System.out.println("Please enter y or n!");
                }
            }while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
            if(choice.equalsIgnoreCase("n")){
                break;
            }
        }while (true);

        System.out.println("2. Add Teacher.");
        do{
            Teacher teacher = enterTeacher();
            MANAGE.addTeacher(teacher);
            String choice;
            do {
                System.out.print("Do you want to continue? (y/n): ");
                choice = INPUT.next();
                INPUT.nextLine();
                if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
                    System.out.println("Please enter y or n!");
                }
            }while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

            if(choice.equalsIgnoreCase("n")){
                break;
            }
        }while (true);

        System.out.println("3. Add Course.");

        do{
            String name;
            do {
                System.out.print("Enter your course's name: ");
                name = INPUT.nextLine();
                if(name.trim().isEmpty()){
                    System.out.println("Please enter your course's name!");
                }
            }while(name.trim().isEmpty());
            CourseRegistrationManagement crm = (CourseRegistrationManagement) MANAGE;
            List<Teacher> teachers = crm.getTeachers();
            for(Teacher teacher : teachers){
                System.out.println(teacher);
            }
            int chooseTeacher = 0;
            do {
                try {
                    System.out.print("Choose the teacher: ");
                    chooseTeacher = INPUT.nextInt();
                }catch (Exception e){
                    System.out.println("Please enter a number!");
                    continue;
                }
                if(chooseTeacher < 1 || chooseTeacher > teachers.size()){
                    System.out.println("Please choose the teacher in the list!");
                }
            }while(chooseTeacher < 1 || chooseTeacher > teachers.size());
            Teacher teacher = teachers.get(chooseTeacher - 1);
            Course course = new Course(name, teacher);
            MANAGE.addCourse(course);
            teacher.getCourses().add(course);

            String choice;
            do {
                System.out.print("Do you want to continue? (y/n): ");
                choice = INPUT.next();
                INPUT.nextLine();
                if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
                    System.out.println("Please enter y or n!");
                }
            }while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

            if(choice.equalsIgnoreCase("n")){
                break;
            }
        }while (true);

        System.out.println("4. Register Course.");

        do {
            CourseRegistrationManagement crm = (CourseRegistrationManagement) MANAGE;
            String id;
            do {
                System.out.print("Enter your ID: ");
                id = INPUT.next();
                INPUT.nextLine();
                if(id.trim().isEmpty()){
                    System.out.println("Please enter your ID!");
                }
            }while(id.trim().isEmpty());

            boolean found = false;
            Student student = null;
            List<Student> students = crm.getStudents();
            if(!students.isEmpty()){
                for (Student st : students){
                    if(st.getId().equalsIgnoreCase(id)){
                        student = st;
                        found = true;
                    }
                }
            }
            if(!found){
                System.out.println("ID is not correct!");
                continue;
            }

            List<Course> courses = crm.getCourses();
            for(Course course : courses){
                System.out.println(course);
            }
            int chooseCourse = 0;
            do {
                try {
                    System.out.print("Choose the couse: ");
                    chooseCourse = INPUT.nextInt();
                }catch (Exception e){
                    System.out.println("Please enter a number!");
                    continue;
                }
                if(chooseCourse < 1 || chooseCourse > courses.size()){
                    System.out.println("Please choose the teacher in the list!");
                }
            }while(chooseCourse < 1 || chooseCourse > courses.size());
            Course course = courses.get(chooseCourse - 1);
            crm.registerCourse(student, course);
            String choice;
            do {
                System.out.print("Do you want to continue? (y/n): ");
                choice = INPUT.next();
                INPUT.nextLine();
                if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
                    System.out.println("Please enter y or n!");
                }
            }while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

            if(choice.equalsIgnoreCase("n")){
                break;
            }
        }while(true);

        CourseRegistrationManagement crm = (CourseRegistrationManagement) MANAGE;
        List<Teacher> teachers = crm.getTeachers();
        for(Teacher teacher : teachers){
            List<Student> students = teacher.getStudents();
            for(Student student : students){
                System.out.println(student);
            }
        }
     }
}