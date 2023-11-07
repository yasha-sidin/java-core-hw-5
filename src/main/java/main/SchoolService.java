package main;

public class SchoolService {
    public static Object[] getHonorsStudents(StudentsGroup studentsGroup) {
        return studentsGroup.getStudents().stream()
                .filter(x -> x.getAverageGrade() > 4.5 && x.getSpeciality() == Speciality.IT)
                .sorted()
                .limit(5).toArray();
    }
}
