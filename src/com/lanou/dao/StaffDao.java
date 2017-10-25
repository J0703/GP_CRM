package com.lanou.dao;

import com.lanou.domain.HR.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffDao extends BaseDao<Staff> {
    List<Staff> findStaff(Map<String, Object> params);
}
