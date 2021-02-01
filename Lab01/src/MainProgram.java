import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Student s1 = new Student("Nat", "123456", "F");
        Student s2 = new Student("Tin", "567890", "M");
        System.out.println(s1.getName());
        System.out.println(s2.getName());
        System.out.println(s1);
        System.out.println(s2);

        Fraction f1 = new Fraction(10, 20);
        Fraction f2 = new Fraction(50, 60);
        Fraction f3 = f1.add(f2);
        System.out.println(f1+" + "+f2+" = "+f3);

        CalculateStamps c1 = new CalculateStamps(1250.59);
        System.out.println(c1.getStamps());

        GuessNumbers g1 = new GuessNumbers(5);
        g1.guessTarget(5);
        g1.guessTarget(4);
        g1.guessTarget(6);

        CafeCard cc1 = new CafeCard();
        cc1.addCredit(90);
        cc1.addCredit(100);
        cc1.paid(50);

        EmployeeCafeCard e1 = new EmployeeCafeCard("Nat");
        e1.addCredit(80);
        e1.addCredit(500);
        e1.paid(500);


    }


}
//Primitive ขึ้นต้นด้วยตัวเล็ก คือ type ที่มีอยู่แล้ว
//User Define ขึ้นต้นด้วยตัวใหญ่
//String ไม่ใช่ Primitive แต่ทำตัวเลียนแบบ Primitive แต่ที่จริงเป็น object
//method มี ()
//tab enter ช่องว่าง ถือว่าเป็น next
//ใน Main ไม่ต้องใส่ Access modifier เช่น private
//Aggregation ส่ง object ผ่าน passing parameter
//Composition เก็บ object เป็น attribute