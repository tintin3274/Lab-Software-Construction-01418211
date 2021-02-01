public class MainProgram {
    public static void main(String[] args) {
        Vehicle v1 = new Car(4, "Honda", 4);
        v1.move();
        //Car c1 = new Vehicle(4, "ll"); แบบนี้ไม่ได้

//        Vehicle v1 = new Vehicle(2, "vv");
//        Car c1 = new Car(4, "honda", 4);
//
//        v1.move();
//        System.out.println("----");
//        c1.move();
//        System.out.println("----");
//        c1.move(100);
//        System.out.println("----");
//        c1.startEngine();
//        System.out.println("----");
    }
}

//ซ้าย static ใช้ method ชื่ออะไรได้บ้าง
//ขวา dynamic ใช้ method ของคลาสไหน