public class Fraction {
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public Fraction add(Fraction other) {
        int p = numerator * other.getDenominator() + denominator * other.getNumerator();
        int q = denominator * other.getDenominator();
        return new Fraction(p, q);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
