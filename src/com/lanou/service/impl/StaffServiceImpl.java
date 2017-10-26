package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.HR.Post;
import com.lanou.domain.HR.Staff;
import com.lanou.service.StaffService;

import java.util.HashMap;
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
    public Staff findById(int staffID) {
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


    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
