package com.lanou.service.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.dao.PostDao;
import com.lanou.domain.HR.Department;
import com.lanou.domain.HR.Post;
import com.lanou.service.DepartmentService;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return departmentDao.findAll(hql);
    }

    @Override
    public Department findById(int depID) {

       return departmentDao.findById(depID,Department.class);


    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }


    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
