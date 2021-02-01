//elab-source:MonsterBall.java

public class MonsterBall {
    private String monsterBallType;
    private double price;
    private double sellFor;
    private double ballValue;

    public MonsterBall(String monsterBallType, double price, double sellFor, double ballValue){
        this.monsterBallType = monsterBallType;
        this.price = price;
        this.sellFor = sellFor;
        this.ballValue = ballValue;
    }

    @Override
    public String toString() {
        return "MonsterBall{type='"+monsterBallType+"', price="+price+", sellFor="+sellFor+", ballValue="+ballValue+"}";
    }
}
