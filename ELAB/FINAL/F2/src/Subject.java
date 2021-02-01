//elab-source:Subject.java

import java.util.TreeMap;

public class Subject {
    private String name;
    private int weight;
    private TreeMap<String, Student> students = new TreeMap<>();

    public Subject(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void register(Student student){
        students.put(student.getName(), student);
    }

    public TreeMap<String, Student> getStudents() {
        return students;
    }
}
