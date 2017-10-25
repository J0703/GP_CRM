package com.lanou.domain.HR;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/24.
 */
public class Department {
    private int depID;
    private String depName;
    private Set<Post> posts = new HashSet<>();

    public Department(String depName) {
        this.depName = depName;
    }

    public Department(int depID, String depName) {

        this.depID = depID;
        this.depName = depName;
    }

    public Department(int depID, String depName, Set<Post> posts) {
        this.depID = depID;
        this.depName = depName;
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID=" + depID +
                ", depName='" + depName + '\'' +
                ", posts=" + posts +
                '}';
    }

    public Department() {
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
