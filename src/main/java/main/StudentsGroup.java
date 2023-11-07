package main;

import main.Student;

import java.util.LinkedList;

public class StudentsGroup {
    private final LinkedList<Student> students;

    public StudentsGroup() {
        this.students = new LinkedList<>();
    }

    public StudentsGroup(LinkedList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
}
