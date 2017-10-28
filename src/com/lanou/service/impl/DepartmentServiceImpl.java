package com.lanou.service.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.domain.hr.Department;
import com.lanou.service.DepartmentService;
import com.lanou.util.PageBean;

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
    public Department findById(String depID) {

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

    @Override
    public void saveOrUpdate(Department department) {
        departmentDao.saveOrUpdate(department);
    }

    @Override
    public PageBean<Department> findByPage(int pageSize, int pageNum) {
        //查找部门的个数语句
       String hql = "select count(*) from Department";
        String hql1 = "from Department where 1=1";
        //查找部门的记录数
        int totalRecord = departmentDao.getTotalRecord(hql);
        PageBean<Department> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        //从起始位置到查询的条数 的 部门
        List<Department> data =  departmentDao.findPageAll(hql1,pageBean.getStartIndex(),pageBean.getPageSize());
        System.out.println(data);
        pageBean.setDate(data);
        return pageBean;
    }


    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
