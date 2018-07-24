package business;

import java.io.Serializable;
public class User implements Serializable {

    public User(String name, String email, String type, int numOfPosts, int numOfPostedReviews) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.numOfPosts = numOfPosts;
        this.numOfPostedReviews = numOfPostedReviews;
    }

    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getNumOfPosts() {
        return numOfPosts;
    }

 
    public void setNumOfPosts(int numOfPosts) {
        this.numOfPosts = numOfPosts;
    }

    public int getNumOfPostedReviews() {
        return numOfPostedReviews;
    }

 
    public void setNumOfPostedReviews(int numOfPostedReviews) {
        this.numOfPostedReviews = numOfPostedReviews;
    }

    private String name;
    private String email;
    private String type;
    private String password;
    private int numOfPosts;
    private int numOfPostedReviews;

    public User() {
        name = "";
        email = "";
        type = "";
        password = "";
        numOfPosts = 0;
        numOfPostedReviews = 0;
    }

    public User(String name, String email, String type,String password, int numOfPosts, int numPostedReviews) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.numOfPosts = numOfPosts;
        this.numOfPostedReviews = numPostedReviews;
        this.password = password;
    }

    
}
