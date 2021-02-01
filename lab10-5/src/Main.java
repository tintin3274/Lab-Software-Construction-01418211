import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());

        Box<Double> doubleBox = new Box<>();
        doubleBox.set(100.0);
        System.out.println(doubleBox.get());

        Box<Student> studentBox = new Box<>();
        studentBox.set(new Student("Tin"));
        studentBox.get().addScore(99.99);
        System.out.println(studentBox.get());

        Pair<String, Double> pair1 = new OrderedPair<>("Tin", 99.99);
        System.out.println(pair1.getKey());
        System.out.println(pair1.getValue());

        Pair<Integer, Box<Student>> pair2;
        pair2 = new OrderedPair<>(1, new Box<>());
        pair2.getValue().set(new Student("Tin Ner"));
        pair2.getValue().get().addScore(99.99);

        System.out.println(pair2.getKey());
        System.out.println(pair2.getValue().get());

        System.out.println("\n/////////////////////////////////////\n");

        ArrayList<Student> students = new ArrayList<>();

        Student s1 = new Student("Nat");
        s1.addScore(45.55);
        Student s2 = new Student("Punch");
        s2.addScore(75.13);
        Student s3 = new Student("Mark");
        s3.addScore(50.45);
        students.add(s1);
        students.add(s2);
        students.add(s3);


        System.out.println(Data.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore()-o2.getScore() > 0) return 1;
                else if (o1.getScore()-o2.getScore() < 0) return -1;
                else return 0;
            }
        }));

        System.out.println(Data.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()) * -1;
            }
        }));
    }
}
