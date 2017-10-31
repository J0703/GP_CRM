package com.lanou.interceptor;

import com.lanou.domain.hr.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/30.
 */
public class SaveOrUpdateInterceptor extends MethodFilterInterceptor{
    /**
     * 拦截,只有用户名为666的员工可以操作
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Staff staff = (Staff) ServletActionContext.getRequest().getSession().getAttribute("loginStaff");
        System.out.println(staff);
        if (!staff.getStaffName().equals("666")){
            return "reject";
        }

        return actionInvocation.invoke();
    }
}
