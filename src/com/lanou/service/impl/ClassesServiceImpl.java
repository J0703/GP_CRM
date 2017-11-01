package com.lanou.service.impl;

import com.lanou.dao.ClassesDao;
import com.lanou.domain.tr.Classes;
import com.lanou.service.ClassesService;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public class ClassesServiceImpl implements ClassesService {
    private ClassesDao classesDao;


    @Override
    public List<Classes> findClasses() {
        String hql = "from Classes";
       return classesDao.findAll(hql);
    }

    @Override
    public void save(Classes classes) {
        classesDao.save(classes);
    }

    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }
}
