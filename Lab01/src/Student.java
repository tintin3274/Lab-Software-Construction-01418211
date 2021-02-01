import java.time.LocalDateTime;

public class Student {
    private String name;
    private String id;
    private String gender;

    public Student(String name, String id, String gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void sleep(LocalDateTime time) {
        System.out.println("sleep" + time);

    }

    public String toString() {
        return "name = " + name + " id = " + id + " gender = " + gender;
    }
}

//Attribute คือ ส่วนประกอบของ Class
//Method คือ ความสามารถของ Class เขียนชื่อขึ้นต้นตัวพิมพ์เล็ก
//void ใช้ได้แค่กับ method
//ตัวแปร global ชนิด Primitive จะถูกกำหนดค่าเริ่มต้นให้อัตโนมัติจาก Constructor
//toSting ควร Override
//Constructor กับ toSting ควรจะมีทุก Class
