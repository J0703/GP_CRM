package com.lanou.dao;

import com.lanou.domain.hr.Department;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public interface BaseDao<T> {
    /**
     * 查询所有，返回查询到的结果集合
     *
     * @return 查询到的结果集合
     **/
    List<T> findAll(String hql);

    /**
     * 根据条件查询，返回查询到的结果集合
     *
     * @param hql    查询语句
     * @param params 查询语句的参数列表
     * @return 查询到的结果集合
     **/
    List<T>find(String hql, Map<String,Object>params);

    /**
     * 根据条件查询，返回查询到的第一个对象
     *
     * @param hql    查询语句
     * @param params 查询语句的参数列表
     * @return 第一个查询到的对象
     **/
    T findSingle(String hql,Map<String,Object>params);

    /**
     * 通过id获取
     * @param id 序列化 id
     * @param tClass
     * @return
     */
    T findById(Serializable id, Class<T>tClass);

    /**
     * 更新
     * @param t 更新对象
     */
    void update(T t);

    /**
     * 保存
     * @param t 保存对象
     */
    void save(T t);

    /**
     * 更新保存
     * @param t
     */
    void saveOrUpdate(T t);

    int getTotalRecord(String hql);

    List<T> findPageAll(String hql1, int startIndex, int pageSize);
}
