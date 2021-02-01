import java.util.ArrayList;
import java.util.Comparator;

public class ScoreMostToLeast implements SortScore {
    @Override
    public void sortScore(ArrayList<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore() == o2.getScore()) return 0;
                return (o1.getScore() > o2.getScore() ? -1 : 1);
            }
        });
    }
}
