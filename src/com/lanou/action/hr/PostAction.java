package com.lanou.action.hr;
import com.lanou.domain.hr.Department;
import com.lanou.domain.hr.Post;
import com.lanou.service.DepartmentService;
import com.lanou.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport implements ModelDriven<Post>{
    @Autowired
    @Qualifier("postService")
    private PostService postService;
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;
    private Post post;
    private String depID;
    private List<Post> posts;

    /**
     * 找到所有的职务
     * @return
     */
    public String findPost() {
        posts = postService.findPost();
        return SUCCESS;
    }

    /**
     * 编辑时,职务回显
     * 根据id查到所属职务
     * @return
     */
    public String beforeUpdatePost() {
        post = postService.findById(post.getPostID());
        return SUCCESS;
    }

    /**
     * 编辑,添加部门
     * @return
     */
    public String saveOrUpdatePost() {
        Department department = departmentService.findById(depID);
        System.out.println(department);
        if (post.getPostID().equals("")){
           post.setPostID(null);
       }
        post.setDepartment(department);
        postService.saveOrUpdate(post);
        return SUCCESS;
    }


    @Override
    public Post getModel() {
        post = new Post();
       return post;
    }
    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
