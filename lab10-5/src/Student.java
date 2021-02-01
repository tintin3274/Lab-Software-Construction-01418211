public class Student {
    private String name;
    private double score;

    public Student(String name) {
        this.name = name;
    }

    public void addScore(double score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
