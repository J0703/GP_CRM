package com.lanou.service;

import com.lanou.domain.HR.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffService {
    List<Staff> findAll();

    List<Staff> findStaff(Map<String, Object> params);
}