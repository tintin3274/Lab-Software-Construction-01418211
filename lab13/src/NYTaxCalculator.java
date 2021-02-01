public class NYTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double purchase) {
        if (purchase > 100) return  purchase * 0.08;
        return 0;
    }
}
