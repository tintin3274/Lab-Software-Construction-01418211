public class EmployeeCafeCard extends CafeCard {
    public EmployeeCafeCard() {
        super();
    }

    public EmployeeCafeCard(String name) {
        super(name);
    }

    @Override
    public void addCredit(double amount) {
        if(amount>=200){
            amount = amount*1.1;
        }
        super.addCredit(amount);
    }

    public void paid(double amount) {
        amount = amount*0.9;
        super.paid(amount);
    }
}