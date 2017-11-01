package com.lanou.action.tr;

import com.lanou.domain.tr.Classes;
import com.lanou.domain.tr.CourseType;
import com.lanou.service.ClassesService;
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
@Controller("classesAction")
@Scope("prototype")
public class ClassesAction extends ActionSupport implements ModelDriven<Classes> {
    private Classes classes;
    private int courseTypeId;

    @Autowired
    @Qualifier("classesService")
    private ClassesService classesService;
    @Autowired
    @Qualifier("courseTypeService")
    private CourseTypeService courseTypeService;
    private List<Classes> classesList;

    public String findClasses(){
        classesList = classesService.findClasses();
        return SUCCESS;
    }

    public String saveClasses(){
        CourseType courseType = courseTypeService.findById(courseTypeId);
        System.out.println(courseType);
        classes.setCourseType(courseType);
        classesService.save(classes);
        return SUCCESS;
    }
    @Override
    public Classes getModel() {
        classes = new Classes();
        return classes;
    }

    public ClassesService getClassesService() {
        return classesService;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
