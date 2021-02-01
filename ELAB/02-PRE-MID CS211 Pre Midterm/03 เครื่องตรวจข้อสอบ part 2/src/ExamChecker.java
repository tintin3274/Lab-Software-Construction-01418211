//elab-source:ExamChecker.java

public class ExamChecker {
    private char trueAnswer[];
    private int scorePerPoint[];
    private int point;

    public ExamChecker(String trueAnswer){
        this.trueAnswer = trueAnswer.toCharArray();
        this.point = trueAnswer.length();
        this.scorePerPoint = new int[point];
    }

    public void Check(String studentAnswer){
        char answer[] = studentAnswer.toCharArray();
        for(int i=0; i<point; i++){
            if(trueAnswer[i] == answer[i]){
                scorePerPoint[i]++;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<point; i++){
            result += (i+1)+": "+scorePerPoint[i]+"\n";
        }
        return result;
    }
}
