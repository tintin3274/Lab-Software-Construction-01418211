public class CashRegisterTester {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        register.recordPurchase(60);
        register.recordPurchase(40);

        String state = "CA"; // สมมติให้เรียกจาก API ตัวอื่นแล้วได้ค่ามา

        if (state.equals("CA")){
            register.setTaxCalculator(new FixedRateTaxCalculator(0.075));
        }
        else if (state.equals("NY")){
            register.setTaxCalculator(new NYTaxCalculator());
        }
        else {
            register.setTaxCalculator(new FixedRateTaxCalculator(0.07));
        }

        register.enterPayment(200);
        double change = register.giveChange();
        System.out.println(change);
    }
}
