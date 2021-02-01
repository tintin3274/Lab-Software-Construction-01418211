//elab-source:ExamChecker.java

public class ExamChecker {
    private char trueAnswer[];
    private int point;
    private int score[];
    private int sum;
    private int n;

    public ExamChecker(String trueAnswer, int n){
        this.trueAnswer = trueAnswer.toCharArray();
        this.point = trueAnswer.length();
        this.score = new int[n];
        this.n = n;
        sum = 0;
    }

    public void Check(String studentAnswer, int index){
        char answer[] = studentAnswer.toCharArray();
        for(int i=0; i<point; i++){
            if(trueAnswer[i] == answer[i]){
                score[index]++;
            }
        }
        sum += score[index];
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<n; i++){
            result += (i+1)+": "+score[i]+"/"+point+"\n";
        }
        result += "Average: "+((float)sum/n);
        return result;
    }
}
