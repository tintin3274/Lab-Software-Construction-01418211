public class Main {
    public static void main(String[] args) {
        System.out.println("---Gray Card---");
        GrayCard anonymous = new GrayCard();
        anonymous.topUp(100);
        anonymous.spend(35);
        System.out.println("Balance: "+anonymous.getBalance());

        System.out.println("---Green Card---");
        GreenCard student = new GreenCard();
        student.topUp(100);
        student.spend(45);
        student.topUp(200);
        System.out.println("Balance: "+student.getBalance());

        System.out.println("---Blue Card---");
        BlueCard staff = new BlueCard();
        staff.topUp(100);
        staff.spend(40);
        staff.topUp(200);
        staff.spend(50);
        staff.usePoint(5);
        System.out.println("Balance: "+staff.getBalance()+" - Point: "+staff.getPoint());
    }
}
