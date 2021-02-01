public class Main {
    public static void main(String[] args) {
        PositiveMixedFraction m = new PositiveMixedFraction(9, 21474837*9, 21474837);
        System.out.println(m.getWholeNumber()+"-"+m.getNominator()+"/"+m.getDenominator());
    }
}
