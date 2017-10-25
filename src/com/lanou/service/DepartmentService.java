package com.lanou.service;

import com.lanou.domain.HR.Department;
import com.lanou.domain.HR.Post;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {
    List<Department> findAll();

    Department findById(int depID);

    void update(Department department);

    void save(Department department);
}
