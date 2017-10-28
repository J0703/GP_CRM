package com.lanou.dao.impl;

import com.lanou.dao.BaseDao;
import com.lanou.domain.hr.Department;
import com.lanou.util.PageHibernateCallback;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    /**
     * 查询所有
     * @param hql 查询语句
     * @return
     */
    @Override
    public List<T> findAll(String hql) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        List<T> tList = query.list();
        return tList;
    }

    /**
     * 条件查询
     * @param hql    查询语句
     * @param params 查询语句的参数列表
     * @return
     */
    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = currentSession();
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

    /**
     * 通过id获取
     * @param id 序列化 id
     * @param tClass
     * @return
     */
    @Override
    public T findById(Serializable id, Class<T> tClass) {
        Session session = currentSession();
        T t = (T) session.get(tClass, id);
        return t;
    }

    /**
     * 更新
     * @param t 更新对象
     */
    @Override
    public void update(T t) {
        Session session = currentSession();
        session.update(t);
    }

    /**
     * 保存
     * @param t 保存对象
     */
    @Override
    public void save(T t) {
        Session session =currentSession();
        session.save(t);

    }

    /**
     * 保存和更新
     * @param t 保存更新对象
     */
    @Override
    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }



    @Override
    public int getTotalRecord(String hql) {
        //返回所有对象
        List<Long> find = (List<Long>) this.getHibernateTemplate().find(hql);
        if (find!=null){
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<T> findPageAll(String hql1, int startIndex, int pageSize) {
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql1,startIndex,pageSize));
    }

}
