package com.lanou.service.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.domain.hr.Department;
import com.lanou.service.DepartmentService;
import com.lanou.util.PageBean;
import freemarker.ext.beans.HashAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    /**
     * 找到所有的部门
     * @return
     */
    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return departmentDao.findAll(hql);
    }

    /**
     * 根据id找到部门
     * @param depID : 部门id
     * @return
     */
    @Override
    public Department findById(String depID) {

       return departmentDao.findById(depID,Department.class);


    }

    /**
     * 更新部门
     * @param department
     */
    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    /**
     * 保存新的部门
     * @param department
     */
    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    /**
     * 部门存在则更新数据,不存在则创建id保存数据
     * @param department
     */
    @Override
    public void saveOrUpdate(Department department) {
        departmentDao.saveOrUpdate(department);
    }

    /**
     * 分页显示部门
     * @param pageSize : 每页显示的数据(3条)
     * @param pageNum : 从第几页开始显示,第一次=1
     * @return
     */
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
        pageBean.setDate(data);
        return pageBean;
    }

    @Override
    public Department findByName(String depName) {
        String hql ="from Department where depName=:name";
        Map<String,Object> params = new HashMap<>();
        params.put("name",depName);
       return departmentDao.findSingle(hql,params);

    }


    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


}
