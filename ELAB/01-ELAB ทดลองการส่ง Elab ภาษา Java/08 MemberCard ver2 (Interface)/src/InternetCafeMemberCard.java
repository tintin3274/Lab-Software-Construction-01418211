// elab-source: InternetCafeMemberCard.java

public class InternetCafeMemberCard implements Pointable {
    private String name;
    private int totalHour;
    private int point;

    public InternetCafeMemberCard(String name){
        this.name = name;
        this.totalHour = 0;
        this.point = 0;
    }

    @Override
    public void addScore(double score) {
        totalHour += score;
        point += score/2;
    }

    @Override
    public void usePoint(int point) {
        if(this.point>=point){
            this.point -= point;
        }
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public String getInfo() {
        return "InternetCafeMemberCard{name='"+name+"', totalHour="+totalHour+", point="+point+"}";
    }
}
