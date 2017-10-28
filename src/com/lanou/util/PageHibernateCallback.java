package com.lanou.util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/10/27.
 */

/**
 * 通过HibernateCallback,可以完全使用Hibernate灵活的方式来访问数据库,解决Spring封装Hibernate后灵活性不足的缺陷
 * @param <T>
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
    private String hql; //hql语句
    private Object[]params; //参数
    private int startIndex;//开始索引
    private int pageSize;//每页显示的条目数

    public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize) {
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    public PageHibernateCallback(String hql, int startIndex, int pageSize) {
        this.hql = hql;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    /**
     *  在开发者提供HibernateCallback实现类时,必须实现接口里包含的doInHibernate方法,在该方法体中可以获得Hibernate Session 的引用
     *  一旦获得了Hibernate Session的引用,就可以完全以Hibernate的方式进行数据库访问
     * @param session :
     * @return
     * @throws HibernateException
     */
    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        //1.通过sql语句获取query参数
        Query query = session.createQuery(hql);
        //2.条件的设置
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i,params[i]);
            }
        }
        //3.分页
        query.setFirstResult(startIndex);//起始位置
        query.setMaxResults(pageSize);//查询的最大条数
        //4.查询所有
        return query.list();
    }
}
