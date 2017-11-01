package com.lanou.service;

import com.lanou.domain.tr.Classes;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public interface ClassesService {
    List<Classes> findClasses();

    void save(Classes classes);
}
