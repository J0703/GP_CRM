package com.lanou.dao.impl;

import com.lanou.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class BaseDaoImpl<T>  implements BaseDao<T> {
    private SessionFactory sessionFactory;
    @Override
    public List<T> findAll(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<T> tList = query.list();
        return tList;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if (params!=null && !params.isEmpty()){
            for (String key : params.keySet()) {
                query.setParameter(key,params.get(key));
            }
        }
        List<T> tList = query.list();

        return tList;
    }

    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        List<T> tList = find(hql,params);
        if (tList.size()>0){
            return tList.get(0);
        }
        return null;
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {
        Session session = sessionFactory.getCurrentSession();
        T t = (T) session.get(tClass, id);
        return t;
    }

    @Override
    public void update(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
    }

    @Override
    public void save(T t) {
        Session session =sessionFactory.getCurrentSession();
        session.save(t);
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
