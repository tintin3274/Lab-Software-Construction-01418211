//elab-source: Twitter.java

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Twitter {
    private LinkedHashMap<String, User> users = new LinkedHashMap<>();
//    private ArrayList<User> usersArrayList = new ArrayList<>();

    public void addUser(String username){
        users.put(username, new User(username));

//        if(users.get(username) == null) {
//            users.put(username, new User(username));
//            usersArrayList.add(users.get(username));
//        }
//        else {
//            usersArrayList.add(users.get(username));
//        }

    }

    public void follow(String username1, String username2){
        if(!users.get(username2).getFollower().contains(users.get(username1))) users.get(username2).addFollower(users.get(username1));
    }

    public void post(String username, String text){
        String postStatus = "("+username+") "+text;
        for(User u : users.get(username).getFollower()){
            u.addNewsFeed(postStatus);
        }
    }

    public void showFeeds() {
        for(String k : users.keySet()){
            System.out.println(k+":");
            for(String t : users.get(k).getNewsFeed()){
                System.out.println(t);
            }
        }
    }

//    public void showFeeds() {
//        for(User user : usersArrayList){
//            System.out.println(user.getUsername()+":");
//            for(String t : user.getNewsFeed()){
//                System.out.println(t);
//            }
//        }
//    }
}