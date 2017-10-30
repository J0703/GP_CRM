package com.lanou.action.hr;

import com.lanou.domain.hr.Post;
import com.lanou.domain.hr.Staff;
import com.lanou.service.PostService;
import com.lanou.service.StaffService;
import com.lanou.util.CipherUtil;
import com.lanou.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/27.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    @Autowired
    @Qualifier("postService")
    private PostService postService;
    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;
    private Staff staff;
    private String depID;
    private String postID;
    private List<Post> posts;
    private List<Staff> staffs;
    private String oldPassword;//原始密码
    private String newPassword;//新密码
    private String reNewPassword;//确认新密码

    private int pageNum = 1; //第一次从第一页开始
    private int pageSize =3; //每页显示三条数据

    /**
     * 分页查员工
     * @return
     */
    public String findByPage(){
        PageBean<Staff> pageBean = staffService.findByPage(pageNum,pageSize);
        ActionContext.getContext().put("pageBean",pageBean);
        return SUCCESS;
    }

    /**
     * 查找所有员工
     *
     * @return
     */
    public String findStaff() {
        staffs = staffService.findAll();
        return SUCCESS;
    }

    /**
     * 高级查询
     * @return
     */
    public String showStaff() {
        if (postID.equals("-1") && depID.equals("-1") && StringUtils.isBlank(staff.getStaffName())) {
            findStaff();
            return SUCCESS;
        }
        if (postID.equals("-1") && StringUtils.isBlank(staff.getStaffName())) {
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
            if (staff.getStaffName().trim().length() > 0) {
                params.put("name", "%" +staff.getStaffName()+"%");
            }
            staffs = staffService.findStaff(params);

        }
        return SUCCESS;
    }

    /**
     * 编辑之前 员工回显
     * 根据员工id查到员工
     *
     * @return
     */

    public String beforeUpdateStaff() {
        staff = staffService.findById(staff.getStaffID());
        return SUCCESS;
    }

    public String beforeAddStaff(){
        return SUCCESS;

    }

    /**
     * 编辑员工
     *
     * @return
     */
    public String updateStaff() {
        Post post = postService.findById(postID);
        staff.setPost(post);
        staffService.saveOrUpdate(staff);
        return SUCCESS;
    }

    /**
     * 添加员工
     *
     * @return
     */
    public String addStaff() {
        Post post = postService.findById(postID);
        staff.setPost(post);
        //加密 密码
        CipherUtil cipherUtil = new CipherUtil();
        String passwprd = cipherUtil.generatePasswprd(staff.getLoginPwd());
        staff.setLoginPwd(passwprd);
        staffService.save(staff);
        return SUCCESS;
    }

    /**
     * 员工登录
     * @return
     */
    public String login(){
        staffs = staffService.login(staff.getLoginName());
        CipherUtil cipherUtil = new CipherUtil();
        //验证输入的密码是否正确
        if (cipherUtil.validatePasword(staffs.get(0).getLoginPwd(),staff.getLoginPwd()) ){
            ServletActionContext.getRequest().getSession().setAttribute("loginStaff",staffs.get(0));
            return SUCCESS;
        }
        return ERROR;
    }


    /**
     * 针对登录动作进行验证
     * @return
     */

    public void validateLogin() {
        if (StringUtils.isBlank(staff.getLoginName()) || StringUtils.isBlank(staff.getLoginPwd())){
            addActionError("用户名或密码不能为空,请重新输入!");
        }
    }

    /**
     * 重置密码
     * @return
     */
    public String editPassword(){
        staff = staffService.findById(staff.getStaffID());
        CipherUtil cipher = new CipherUtil();
       String old =  cipher.generatePasswprd(oldPassword);
        if (staff.getLoginPwd().equals(old) && newPassword.equals(reNewPassword)){
           staff.setLoginPwd(cipher.generatePasswprd(newPassword));
           staffService.saveOrUpdate(staff);
           return SUCCESS;
        }else {
            addActionError("密码有误请重新设置");
            return ERROR;
        }

    }


    @Override
    public Staff getModel() {
        staff = new Staff();
        return staff;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

