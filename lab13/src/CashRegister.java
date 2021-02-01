public class CashRegister {
    private double purchase; // จํานวนเงินรวมของสินค้าที่ซื้อ
    private double payment; // จํานวนเงินรวมที่ลูกค้าจ่าย
    private TaxCalculator calculator;

    public void setTaxCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public CashRegister() {
        purchase = 0;
        payment = 0;
    }
    public void recordPurchase(double amount) {
        purchase += amount;
    }
    public void calculateTax() {
        purchase = purchase + calculator.calculateTax(purchase);
    }

//    public void calculateTaxCA() {
//        purchase = purchase + purchase *0.075;
//    }
//    public void calculateTaxNY() {
//        purchase = purchase + (purchase > 100 ? purchase*0.08 : 0);
//    }

    public void enterPayment(double amount) {
        payment += amount;
    }
    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;
    }
}
