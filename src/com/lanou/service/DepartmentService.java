package com.lanou.service;

import com.lanou.domain.hr.Department;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {
    List<Department> findAll();

    Department findById(String depID);

    void update(Department department);

    void save(Department department);

    void saveOrUpdate(Department department);

    PageBean<Department> findByPage(int pageSize, int pageNum);
}
