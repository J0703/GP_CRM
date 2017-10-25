package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.HR.Staff;
import com.lanou.service.StaffService;

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

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
