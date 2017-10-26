package com.lanou.action;

import com.lanou.domain.HR.Department;
import com.lanou.domain.HR.Post;
import com.lanou.domain.HR.Staff;
import com.lanou.service.DepartmentService;
import com.lanou.service.PostService;
import com.lanou.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.*;

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
    private List<Post> posts;
    private List<Staff> staffs;
    private int depID;
    private int postID;
    private String staffName;
    private Department department;
    private String depName;
    private Post post;
    private String postName;
    private int staffID;
    private Staff staff;
    private String loginName;
    private String loginPwd;
    private String gender;
    private Date onDutyDate;


    public String findDepartment() {
        departments = departmentService.findAll();
        return SUCCESS;
    }

    public String findPost() {
        posts = postService.findPost();
        return SUCCESS;
    }

    public String showDepartment() {
        departments = departmentService.findAll();
        return SUCCESS;
    }

    public String showPost() {
        posts = postService.findPostById(depID);
        return SUCCESS;
    }

    public String findStaff() {
        staffs = staffService.findAll();
        return SUCCESS;
    }

    public String showStaff() {

        if (postID==-1 && depID==-1 && StringUtils.isBlank(staffName)) {
            findStaff();
            return SUCCESS;
        }
        if (postID==-1 && StringUtils.isBlank(staffName)) {
            Map<String, Object> params = new HashMap<>();
            params.put("depId", depID);
            posts = postService.findPostById(depID);
            staffs = new ArrayList<>();
            for (Post post : posts) {
               postID = post.getPostID();
                params.remove("depId");
                params.put("postId", postID);
                List<Staff> staffList = staffService.findStaff(params);
                staffs.addAll(staffList);
            }

        } else {
            Map<String, Object> params = new HashMap<>();
            params.put("postId", postID);
            if (staffName.trim().length()>0){
                params.put("name", staffName);
            }
            staffs = staffService.findStaff(params);

        }
        return SUCCESS;

    }

    //部门名称回显
    public String BeforeUpdateDepName() {
        department = departmentService.findById(depID);
        return SUCCESS;
    }

    //编辑,添加职务
    public String updateDepartment() {

        if (depID == 0) {
            Department department = new Department(depName);
            departmentService.save(department);

        } else {
            Department department = new Department(depID, depName);
            departmentService.update(department);
        }
        return SUCCESS;
    }

    //职务回显  根据职务id查询到职务
    public String BeforeUpdatePost() {
        post = postService.findById(postID);
        return SUCCESS;
    }

    //编辑,添加部门
    public String updatePost() {
        if (postID == 0) {
            department = departmentService.findById(depID);
            Post post = new Post(postName, department);
            postService.save(post);
        } else {
            department = departmentService.findById(depID);
            Post post = new Post(postID, postName, department);
            postService.update(post);
        }

        return SUCCESS;
    }

    //员工回显  根据员工id查到员工
    public String beforeUpdateStaff() {
        staff = staffService.findById(staffID);
        return SUCCESS;
    }

    //编辑员工
    public String updateStaff() {
        department = departmentService.findById(depID);
        post = postService.findById(postID);
        Staff staff = new Staff(staffID,loginName, loginPwd, staffName, gender, onDutyDate);
        staff.setPost(post);
        staffService.update(staff);
        return SUCCESS;
    }
    //添加员工
    public String addStaff(){
        department = departmentService.findById(depID);
        post = postService.findById(postID);
        Staff staff = new Staff(loginName, loginPwd, staffName, gender, onDutyDate, post);
        staffService.save(staff);
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

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }
}
