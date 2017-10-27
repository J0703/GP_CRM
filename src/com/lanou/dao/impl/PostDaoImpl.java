package com.lanou.dao.impl;

import com.lanou.dao.PostDao;
import com.lanou.dao.impl.BaseDaoImpl;
import com.lanou.domain.hr.Post;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * Created by dllo on 17/10/25.
 */

public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao  {

//    //职务编辑
    @Override
    public void saveOrUpdate(Post post) {
        Session session=currentSession();
        String hql = "UPDATE Post SET postName = ?,depID=? WHERE postID = ? ";
        SQLQuery query= session.createSQLQuery(hql);
        query.setString(0,post.getPostName());
        query.setString(1,post.getDepartment().getDepID());
        query.setString(2,post.getPostID());
        query.executeUpdate();
    }
}
