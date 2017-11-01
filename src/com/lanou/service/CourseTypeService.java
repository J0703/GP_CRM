package com.lanou.service;

import com.lanou.domain.tr.CourseType;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public interface CourseTypeService  {
    List<CourseType> findCourseType();

    CourseType findById(int courseTypeId);
}
