import java.util.*;

public class Facebook {
    private LinkedHashMap<String, User> users;
    public Facebook() {
        users = new LinkedHashMap<>();
    }

    // เติมโค้ดเมธอด void registerUser(User user) ที่ช่องนี้ โดยต้องมีการโยน exception ตามโจทย์กำหนด
    public void registerUser(User user) throws TooYoungException {
        if(user.getAge()<13) throw new TooYoungException();
        users.put(user.getName(), user);
    }

    public User find(String name) {   // เติมโค้ดการค้นหาตามชื่อผู้ใช้
        return users.get(name);
    }

    public List<User> find(int age) {  // เติมโค้ดการค้นหาตามอายุ
        ArrayList<User> result = new ArrayList<>();
        for(User user : users.values()){
            if(user.getAge() == age) result.add(user);
        }
        return result;
    }
}
