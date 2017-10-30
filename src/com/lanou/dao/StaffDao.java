package com.lanou.dao;

import com.lanou.dao.BaseDao;
import com.lanou.domain.hr.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffDao extends BaseDao<Staff> {
    List<Staff> findStaff(Map<String, Object> params);

    List<Staff> login(String loginName);
}
