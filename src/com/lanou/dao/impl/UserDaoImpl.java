package com.lanou.dao.impl;

import com.lanou.dao.UserDao;
import com.lanou.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
    @Override
    public boolean login(String name, String psw) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from User where loginName=:na and password=:psw");
        //设置参数
        query.setParameter("na",name);
        query.setParameter("psw",psw);
        List<User> users = query.list();

        return users.size()>0;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
