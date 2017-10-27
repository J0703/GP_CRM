package com.lanou.service;

import com.lanou.domain.hr.Post;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface PostService {
    List<Post> findPost();

    List<Post> findPostById(String depID);

    Post findById(String postID);

    void save(Post post);

    void update(Post post);

    void saveOrUpdate(Post post);
}
