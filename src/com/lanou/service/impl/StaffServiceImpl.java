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
    @Override
    public List<Staff> findAll() {
        String hql = "from Staff";
       return staffDao.findAll(hql);

    }

    @Override
    public List<Staff> findStaff(Map<String, Object> params) {
       return staffDao.findStaff(params);


    }

    @Override
    public Staff findById(String staffID) {
        return staffDao.findById(staffID,Staff.class);

    }

    @Override
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    @Override
    public void saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

    @Override
    public void update(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public List<Staff> login(String loginName, String loginPwd) {
       return staffDao.login(loginName,loginPwd);

    }

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
