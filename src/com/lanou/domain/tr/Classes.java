package com.lanou.domain.tr;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/28.
 */
public class Classes {
    private int classID; //主键id
    private  int lessonTypeID; //所属课程id
    private String name;//班级名称
    private Date beginTime;//开班时间
    private Date endTime;//毕业时间
    private String status; //状态
    private int totalCount; //学生总数
    private  int upgradeCount;//升级数
    private int changeCount;//转班数
    private int runoffCount;//退费数
    private String remark;
    private String uploadPath;//课表路径
    private String uploadFileName;//课表名称
    private Date uploadTime;//上传时间
    private Set<Course> courses = new HashSet<>();

    public Classes() {
    }

    public Classes(int lessonTypeID, String name, Date beginTime, Date endTime, String status, int totalCount, int upgradeCount, int changeCount) {
        this.lessonTypeID = lessonTypeID;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
    }

    public Classes(String name, Date beginTime, Date endTime, String status, int totalCount, int upgradeCount, int changeCount, Set<Course> courses) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.courses = courses;
    }

    public Classes(int classID, int lessonTypeID, String name, Date beginTime, Date endTime, String status, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, Date uploadTime) {
        this.classID = classID;
        this.lessonTypeID = lessonTypeID;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getLessonTypeID() {
        return lessonTypeID;
    }

    public void setLessonTypeID(int lessonTypeID) {
        this.lessonTypeID = lessonTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
