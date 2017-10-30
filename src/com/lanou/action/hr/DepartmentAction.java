package com.lanou.action.hr;

import com.lanou.domain.hr.Department;
import com.lanou.service.DepartmentService;
import com.lanou.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;
    private List<Department> departments;
    private String depID;
    private Department department;
    private int pageNum = 1; //第一次从第一页开始
    private int pageSize =3; //每页显示三条数据

    /**
     * 分页查部门
     * @return
     */
    public String findByPage(){
        PageBean<Department> pageBean = departmentService.findByPage(pageSize,pageNum);
        ActionContext.getContext().put("pageBean",pageBean);
        return SUCCESS;
    }
    /**
     * 找到所有的部门
     * @return
     */
    public String findDepartment() {
        departments = departmentService.findAll();
        return SUCCESS;
    }


    /**
     *  编辑时部门名称回显
     *  根据id查到所属部门
     * @return
     */

    public String beforeUpdateDepName() {
        String depID = department.getDepID();
        if (!StringUtils.isBlank(depID)){
            department = departmentService.findById(depID);
            return SUCCESS;
        }
        return SUCCESS;
    }

    /**
     * 只有管理员才有权限 编辑,添加部门
     * @return
     */

    public String saveOrUpdate() {
        if (department.getDepID().equals("")){
            department.setDepID(null);
        }
        departmentService.saveOrUpdate(department);

        return SUCCESS;
    }



    @Override
    public Department getModel() {
        department = new Department();
        return department;
    }
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
