import java.util.ArrayList;

public class Classroom {

    private ArrayList<Student> stds; //composition
    private String course;
    private String sec;
    public Classroom(String course, String sec){
        this.course = course;
        this.sec = sec;
        this.stds = new ArrayList<>();
    }

    public void add(Student std){
        stds.add(std);
    }

    //aggregation
    public String printStudent(){
        String allName = "";
//        for (int i =0; i < stds.size(); i++){
//            allName += stds.get(i)+ "\n";
//        } //traditional loop

        for (Student std:stds){
            allName += std+"\n";
        } //enhanced for loop
        return allName;
    }

    public static void main(String[] args) {
//        Student[] stds = new Student[10]; // index 0-9

        ArrayList<Student> stds = new ArrayList<>();

//        stds.add(new Student("kong", "62", "20"));
//        System.out.println(stds.size());
//        stds.get(0);

        Classroom sec11 = new Classroom("01418211", "11");
        sec11.add(new Student("a1", "62", "20"));
        sec11.add(new Student("a2", "62", "20"));
        sec11.add(new Student("a3", "62", "20"));

        System.out.println(sec11.printStudent());
    }
}

//contains ใช้ได้ดีกับ primitive หาว่ามีค่านี้เก็บอยู่ไหม
//compare ใช้ช่วยเปรียบเทียบ

