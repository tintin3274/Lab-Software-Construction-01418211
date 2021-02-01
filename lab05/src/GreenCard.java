public class GreenCard extends FoodCenterCard{
    public GreenCard(){
        super();
    }

    public void topUp(double money){
        if (money < 0)
            throw new IllegalArgumentException("money must be positive");

        super.topUp(money);
        super.topUp(((int) (money / 200)) * 10);
    }
}
