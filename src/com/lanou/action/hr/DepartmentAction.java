package com.lanou.action.hr;

import com.lanou.domain.hr.Department;
import com.lanou.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
        department = departmentService.findById(depID);
        return SUCCESS;
    }

    /**
     *  编辑,添加部门
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


}
