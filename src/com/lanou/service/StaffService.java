package com.lanou.service;

import com.lanou.domain.hr.Post;
import com.lanou.domain.hr.Staff;
import com.lanou.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffService {
    List<Staff> findAll();

    List<Staff> findStaff(Map<String, Object> params);

    Staff findById(String staffID);

    void save(Staff staff);


    void saveOrUpdate(Staff staff);


    void update(Staff staff);

    List<Staff> login(String loginName);

    PageBean<Staff> findByPage(int pageNum, int pageSize);
}
