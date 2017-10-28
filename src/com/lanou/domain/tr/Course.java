package com.lanou.domain.tr;

/**
 * Created by dllo on 17/10/28.
 */
public class Course {
    private int courceTypeID; //主键ID
    private Double courseCost;//课程费用
    private int total;//总课时
    private String courseName; //课程类别名称
    private String remark; //课程介绍模板

    public Course() {
    }

    public Course(Double courseCost, int total, String courseName, String remark) {
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public Course(int courceTypeID, Double courseCost, int total, String courseName, String remark) {
        this.courceTypeID = courceTypeID;
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    public int getCourceTypeID() {
        return courceTypeID;
    }

    public void setCourceTypeID(int courceTypeID) {
        this.courceTypeID = courceTypeID;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
