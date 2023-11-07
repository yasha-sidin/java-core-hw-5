import main.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    private static final LinkedList<String> names = new LinkedList<>(List.of("Jake", "Tom", "Jakob", "Karen", "Bob", "Max", "Frank",
            "Roze", "Borya", "Filip", "Anton", "Liza", "Pole", "Kolya", "Sergey", "Robert", "Duke", "Arseniy", "Yakov", "Maria", "Angelika",
            "Frosinya", "Bobik", "Adam", "Eva", "Roger", "Rob", "Masha", "Sindy", "Lola", "Vita", "Arina", "Anotoliy", "Artur", "Azamat", "Aza",
            "Arhip", "Bogdan", "Beatrisa", "Vadim", "Vanda", "Vlad", "Vlada", "Garry"));
    private static final LinkedList<Speciality> specialities = new LinkedList<>(List.of(Speciality.IT, Speciality.ENGLISH, Speciality.ECONOMICS,
            Speciality.MATH, Speciality.PHYSICS, Speciality.RUSSIAN));
    private static final LinkedList<Grade> grades = new LinkedList<>(List.of(Grade.ONE, Grade.TWO, Grade.THREE, Grade.FOUR, Grade.FIVE));
    public static void main(String[] args) {
        System.out.println("All students: ");
        StudentsGroup testGroup = getTestGroup();
        AtomicInteger count = new AtomicInteger(1);
        testGroup.getStudents().forEach((x) -> {
            System.out.println(count + ") " + x);
            count.addAndGet(1);
        });
        System.out.println("\nFive honors IT students: ");
        Object[] honors = SchoolService.getHonorsStudents(testGroup);
        count.set(1);
        Arrays.stream(honors).map(Object::toString).forEach((x) -> {
            System.out.println(count + ") " + x);
            count.addAndGet(1);
        });
    }

    private static StudentsGroup getTestGroup() {
        StudentsGroup studentsGroup = new StudentsGroup();
        ArrayList<Integer> randoms = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < names.size(); i++) randoms.add(i);
        Collections.shuffle(randoms);
        for (int i = 0; i < names.size(); i++) {
            studentsGroup.addStudent(new Student(names.get(randoms.get(i)), getTestGrades(20, 4, 6),
                    specialities.get(random.nextInt(specialities.size()))));
        }
        return studentsGroup;
    }

    private static LinkedList<Grade> getTestGrades(int n, int min, int max) {
        LinkedList<Grade> gradesList = new LinkedList<>();
        Random random = new Random();
        List<Integer> intList = random.ints(n, min, max)
                .boxed()
                .collect(Collectors.toList());
        intList.stream()
                .forEach(x -> gradesList.add(grades.get(x - 1)));
        return gradesList;
    }
}
