public class CalculateStamps {
    private double payments;
    private int stamps;

    public CalculateStamps(double payments){
        this.payments = payments;
        this.stamps = (int) (payments / 50);
    }

    public int getStamps() {
        return stamps;
    }

}
