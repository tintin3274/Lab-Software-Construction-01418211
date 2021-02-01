public class BlueCard extends FoodCenterCard{
    private int point;

    public BlueCard(){
        super();
        this.point = 0;
    }

    public void topUp(double money){
        if (money < 0)
            throw new IllegalArgumentException("money must be positive");

        super.topUp(money);
        this.point += ((int) (money / 200)) * 10;
    }


    public void spend(double purchase){
        if (purchase > super.getBalance())
            throw new IllegalArgumentException("balance is insufficient");

        super.spend(purchase);
        this.point += ((int) (purchase / 50)) * 2;
    }

    public void usePoint(int point){
        if (point > this.point)
            throw new IllegalArgumentException("point is insufficient");

        this.point -= point;
    }

    public int getPoint() {
        return point;
    }
}
