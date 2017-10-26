package com.lanou.service;

import com.lanou.domain.HR.Post;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface PostService {
    List<Post> findPost();

    List<Post> findPostById(int depID);

    Post findById(int postID);

    void save(Post post);

    void update(Post post);
}
