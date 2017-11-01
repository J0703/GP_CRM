package com.lanou.domain.tr;

/**
 * Created by dllo on 17/10/31.
 */
public class CourseType {
    private int courseTypeId;
    private Double courseCost;
    private int total;
    private String courseName;
    private String remark;

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
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

    public CourseType() {
    }

    public CourseType(Double courseCost, int total, String courseName, String remark) {
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
