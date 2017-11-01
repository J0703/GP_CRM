package com.lanou.action.tr;

import com.lanou.domain.tr.CourseType;
import com.lanou.service.CourseTypeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
@Controller("courseTypeAction")
@Scope("prototype")
public class CourseTypeAction extends ActionSupport implements ModelDriven<CourseType>{
    private CourseType courseType;
    @Autowired
    @Qualifier("courseTypeService")
    private CourseTypeService courseTypeService;
    private List<CourseType> courseTypeList;

    public String findCourseType(){
        courseTypeList = courseTypeService.findCourseType();
        return SUCCESS;
    }
    @Override
    public CourseType getModel() {
        courseType = new CourseType();
        return courseType;
    }

    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    public List<CourseType> getCourseTypeList() {
        return courseTypeList;
    }

    public void setCourseTypeList(List<CourseType> courseTypeList) {
        this.courseTypeList = courseTypeList;
    }
}
