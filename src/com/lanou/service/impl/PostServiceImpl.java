package com.lanou.service.impl;

import com.lanou.dao.PostDao;
import com.lanou.domain.HR.Post;
import com.lanou.service.PostService;

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

    @Override
    public List<Post> findPost() {
        String hql = "from Post";
         return postDao.findAll(hql);
    }

    @Override
    public List<Post> findPostById(int depID) {
        String hql = "from Post where depID=:id";
        Map<String,Object> params = new HashMap<>();
        params.put("id",depID);
         return postDao.find(hql,params);

    }

    @Override
    public Post findById(int postID) {
       return postDao.findById(postID,Post.class);

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
