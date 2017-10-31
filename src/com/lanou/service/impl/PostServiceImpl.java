package com.lanou.service.impl;

import com.lanou.dao.PostDao;
import com.lanou.domain.hr.Post;
import com.lanou.service.PostService;
import com.lanou.util.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */

public class PostServiceImpl implements PostService {

    private PostDao postDao;

    public PostServiceImpl() {
    }

    /**
     * 找到所有的职务
     * @return
     */
    @Override
    public List<Post> findPost() {
        String hql = "from Post";
         return postDao.findAll(hql);
    }

    /**
     * 根据部门id找到对应的职务
     * @param depID 部门id
     * @return
     */
    @Override
    public List<Post> findPostById(String depID) {
        String hql = "from Post where depID=:id";
        Map<String,Object> params = new HashMap<>();
        params.put("id",depID);
         return postDao.find(hql,params);

    }

    /**
     * 根据职务id找到职务
     * @param postID
     * @return
     */
    @Override
    public Post findById(String postID) {
       return postDao.findById(postID,Post.class);

    }

    /**
     * 保存职务
     * @param post
     */
    @Override
    public void save(Post post) {
        postDao.save(post);
    }

    /**
     * 更新职务
     * @param post
     */
    @Override
    public void update(Post post) {
        postDao.update(post);
    }

    /**
     * 职务id存在则更新,不存在则保存
     * @param post
     */
    @Override
    public void saveOrUpdate(Post post) {

        postDao.saveOrUpdate(post);
    }

    /**
     * 职务分页
     * @param pageNum  索引位置
     * @param pageSize 索引条数
     * @return
     */
    @Override
    public PageBean<Post> findByPage(int pageNum, int pageSize) {
        String hql = "select count(*) from Post";
        String hql1 = "from Post where 1=1";
        int totalRecord = postDao.getTotalRecord(hql);
        PageBean<Post> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Post> data = postDao.findPageAll(hql1,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setDate(data);
        return pageBean;
    }

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
