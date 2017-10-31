package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.hr.Post;
import com.lanou.domain.hr.Staff;
import com.lanou.service.StaffService;
import com.lanou.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    /**
     * 找到所有的员工
     * @return
     */
    @Override
    public List<Staff> findAll() {
        String hql = "from Staff";
       return staffDao.findAll(hql);

    }

    /**
     * 根据条件查询
     * @param params 查询参数
     * @return
     */
    @Override
    public List<Staff> findStaff(Map<String, Object> params) {
       return staffDao.findStaff(params);


    }

    /**
     * 根据id查询
     * @param staffID 职员id
     * @return
     */
    @Override
    public Staff findById(String staffID) {
        return staffDao.findById(staffID,Staff.class);

    }

    /**
     * 保存职员
     * @param staff
     */
    @Override
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    /**
     * 更新职员
     * @param staff
     */
    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }

    /**
     * 职员存在则更新 不存在则保存
     * @param staff
     */
    @Override
    public void saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

    /**
     * 登录
     * @param loginName 登录名字
     * @return
     */
    @Override
    public List<Staff> login(String loginName) {
       return staffDao.login(loginName);

    }

    /**
     * 分页查找
     * @param pageNum 索引位置
     * @param pageSize 索引条数
     * @return
     */
    @Override
    public PageBean<Staff> findByPage(int pageNum, int pageSize) {
        String hql = "select count(*) from Staff";
        String hql1 = "from Staff where 1=1";
        int totalRecord = staffDao.getTotalRecord(hql);
        PageBean<Staff> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Staff> data = staffDao.findPageAll(hql1,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setDate(data);
        return pageBean;
    }


    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
