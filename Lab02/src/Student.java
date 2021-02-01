public class Student{
    private String name;
    private String id;
    private String age;

    public Student(String name, String id, String age){
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public String toString(){
        return id+ " " +name+ " " + age;
    }
}