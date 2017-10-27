package com.lanou.domain.hr;

/**
 * Created by dllo on 17/10/24.
 */
public class Post {
    private String postID;
    private String postName;
    private Department department;

    public Post(String postID, String postName) {
        this.postID = postID;
        this.postName = postName;
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post() {
    }

    public Post(String postName, Department department) {
        this.postName = postName;
        this.department = department;
    }

    public Post(String postID, String postName, Department department) {
        this.postID = postID;
        this.postName = postName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID='" + postID + '\'' +
                ", postName='" + postName + '\'' +
                ", department=" + department +
                '}';
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
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
