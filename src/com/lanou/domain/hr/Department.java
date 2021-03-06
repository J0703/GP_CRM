package com.lanou.domain.hr;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/24.
 */
public class Department {
    private String depID; //部门id
    private String depName; //部门名字
    private Set<Post> posts= new HashSet<>(); //部门下对应的职务


    public Department(String depName) {
        this.depName = depName;
    }

    public Department(String depID, String depName) {

        this.depID = depID;
        this.depName = depName;
    }

    public Department(String depID, String depName, Set<Post> posts) {
        this.depID = depID;
        this.depName = depName;
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID='" + depID + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }

    public Department() {
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
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
