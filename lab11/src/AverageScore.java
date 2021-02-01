import java.util.ArrayList;

public class AverageScore {
    private ArrayList<Student> students;
    private Double sumScore;
    private Double average;
    private int number;

    public AverageScore(ArrayList<Student> students) {
        this.students = students;
    }

    public double getAverageScore(){
        sumScore = 0.0;
        average = 0.0;
        number = 0;
        for (Student s : students) {
            sumScore += s.getScore();
            number++;
        }
        average = sumScore/number;
        return average;
    }

}
