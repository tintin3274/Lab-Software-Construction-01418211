import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("Tee");
        names.add("Zee");
        names.add("Zern");
        names.add("Nob");
        names.add("Two Popthorn");
        names.add("Mix");
        names.add("Mix");
        names.remove("Mix");
        System.out.println(names.size());
        System.out.println(names);
        for (String name : names){
            System.out.println(name);
        }

        System.out.println("-----------------------");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        System.out.println("-----------------------");

        LinkedList<String> list = new LinkedList<>();
        list.add("L");
        list.add("O");
        list.add("S");
        list.add("E");
        System.out.println(list);
        String e = list.removeLast();
        String s = list.removeLast();
        System.out.println(list);
        s = "V";
        list.add(s);
        list.add(e);
        System.out.println(list);
        ListIterator<String> iterator1 = list.listIterator();
        while (iterator1.hasNext()){
            String letter = iterator1.next();
            System.out.println(letter);
        }

        System.out.println("-----------------------");

        Map<String, Double> studentScores = new TreeMap<>();
        studentScores.put("Zee", 700.0);
        studentScores.put("Tee", 800.0);
        studentScores.put("Fast", 20.5);
        studentScores.put("Jumbo", 16.4);
        System.out.println(studentScores);
        for (String key : studentScores.keySet()) {
            double score = studentScores.get(key);
            System.out.println(key + ": " + score);
        }

        System.out.println("-----------------------");

        Student s1 = new Student("January");
        s1.addScore(40);
        Student s2 = new Student("February");
        s2.addScore(50);
        Student s3 = new Student("March");
        s3.addScore(45);
        Student s4 = new Student("April");
        s4.addScore(48);

        LinkedList<Student> students = new LinkedList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        System.out.println(students);

        Comparator scoreComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;
                if(s1.getScore()>s2.getScore()) return 1;
                if(s1.getScore()<s2.getScore()) return -1;
                return 0;
            }
        };

        Collections.sort(students, scoreComparator);
        System.out.println(students);

        Comparator nameComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;
                return s1.getName().compareTo(s2.getName());
            }
        };

        Collections.sort(students, nameComparator);
        System.out.println(students);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(students);
    }
}
