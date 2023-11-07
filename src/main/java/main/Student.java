package main;

import main.Grade;
import main.GradeMeanings;
import main.Speciality;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Grade> grades;
    private Speciality speciality;

    public Student(String name, List<Grade> grades, Speciality speciality) {
        this.name = name;
        this.grades = grades;
        this.speciality = speciality;
    }

    public double getAverageGrade() {
        return (double) grades.stream()
                .map(GradeMeanings::getMeaning)
                .mapToInt(Integer::intValue)
                .sum() / (double) grades.size();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Student { Name: " + name + "; Specialize: " + speciality + "; Average grade: " + getAverageGrade() + " }";
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getAverageGrade(), this.getAverageGrade());
    }
}
