package com.lanou.action;

import com.lanou.domain.HR.Department;
import com.lanou.domain.HR.Post;
import com.lanou.domain.HR.Staff;
import com.lanou.service.DepartmentService;
import com.lanou.service.PostService;
import com.lanou.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Autowired
    @Qualifier("postService")
    private PostService postService;

    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;

    private List<Department> departments;
    private List<Post>posts;
    private List<Staff>staffs;
    private int depID;
    private int postID;
    private String staffName;
    private Department department;
    private String depName;
    private Post post;


    public String findDepartment(){
        departments = departmentService.findAll();
        return SUCCESS;
    }

    public String findPost(){
        posts = postService.findPost();
        return SUCCESS;
    }

    public String showDepartment(){
       departments = departmentService.findAll();
        System.out.println(departments);
        return SUCCESS;
    }

    public String showPost(){
       posts = postService.findPostById(depID);
        return SUCCESS;
    }

    public String findStaff(){
        staffs = staffService.findAll();

        return SUCCESS;
    }

    public String showStaff(){
        Map<String,Object> params = new HashMap<>();
        params.put("depId",depID);
        params.put("postId",postID);
        params.put("name",staffName);
        staffs =  staffService.findStaff(params);
        return SUCCESS;
    }

    //部门名称回显
    public String BeforeUpdateDepName(){
        department = departmentService.findById(depID);
        return SUCCESS;
    }

    public String updateDepartment(){
        if (depID==0){
            Department department = new Department(depName);
            departmentService.save(department);

        }else {
            Department department = new Department(depID,depName);
            departmentService.update(department);
        }
        return SUCCESS;
    }
    //职务回显  根据职务id查询到职务
    public String BeforeUpdatePost(){
        post = postService.findById(postID);
        return SUCCESS;
    }


    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
