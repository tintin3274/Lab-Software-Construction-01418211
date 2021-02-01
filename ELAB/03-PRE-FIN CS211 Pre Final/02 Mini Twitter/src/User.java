//elab-source: User.java

import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<User> follower;
    private ArrayList<String> newsFeed;

    public User(String username) {
        this.username = username;
        follower = new ArrayList<>();
        newsFeed = new ArrayList<>();
        follower.add(this);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<User> getFollower() {
        return follower;
    }

    public ArrayList<String> getNewsFeed() {
        return newsFeed;
    }

    public void addFollower(User user){
        follower.add(user);
    }

    public void addNewsFeed(String postStatus){
        newsFeed.add(postStatus);
    }
}
