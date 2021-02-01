// elab-source: MemberCard.java

public class MemberCard implements Pointable {
    private String name;
    private double totalPurchase;
    private int point;
    private int pointUsed;

    public MemberCard(String name) {
        this.name = name;
        this.totalPurchase = 0;
        this.point = 0;
        this.pointUsed = 0;
    }

    @Override
    public void addScore(double score) {
        totalPurchase += score;
        point = (int) totalPurchase/250;
    }

    @Override
    public void usePoint(int point) {
        if(this.point-this.pointUsed>=point){
            pointUsed += point;
        }
    }

    @Override
    public int getPoint() {
        return point-pointUsed;
    }

    @Override
    public String getInfo() {
        return "MemberCard{name='"+name+"', totalPurchase="+totalPurchase+", point="+(point-pointUsed)+"}";
    }
}
