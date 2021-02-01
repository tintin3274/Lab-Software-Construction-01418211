//elab-source:Student.java

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Subject> subjects;

    public Student(String name) {
        this.name = name;
        subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void register(Subject subject){
        subjects.add(subject);
    }

    public int sumWeight(){
        int weight = 0;
        for(Subject subject : subjects){
            weight += subject.getWeight();
        }
        return weight;
    }
}
