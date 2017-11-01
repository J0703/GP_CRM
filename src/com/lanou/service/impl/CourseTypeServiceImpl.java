package com.lanou.service.impl;

import com.lanou.dao.CourseTypeDao;
import com.lanou.domain.tr.CourseType;
import com.lanou.service.CourseTypeService;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public class CourseTypeServiceImpl implements CourseTypeService {
    private CourseTypeDao courseTypeDao;

    public CourseTypeDao getCourseTypeDao() {
        return courseTypeDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CourseType> findCourseType() {
        String hql = "from CourseType";
        return courseTypeDao.findAll(hql);
    }

    @Override
    public CourseType findById(int courseTypeId) {
      return courseTypeDao.findById(courseTypeId,CourseType.class);

    }
}
