package com.lanou.domain.HR;

/**
 * Created by dllo on 17/10/24.
 */
public class Post {
    private int postID;
    private String postName;
    private Department department;

    public Post(int postID, String postName) {
        this.postID = postID;
        this.postName = postName;
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postName='" + postName + '\'' +
                '}';
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
