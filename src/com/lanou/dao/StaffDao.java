package com.lanou.dao;

import com.lanou.dao.BaseDao;
import com.lanou.domain.hr.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffDao extends BaseDao<Staff> {
    /**
     * 根据条件查询职员(高级查询)
     * @param params 查询参数
     * @return
     */
    List<Staff> findStaff(Map<String, Object> params);

    /**
     * 登录
     * @param loginName 登录名字
     * @return
     */
    List<Staff> login(String loginName);
}
