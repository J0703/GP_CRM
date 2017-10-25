package com.lanou.action;

import com.lanou.domain.User;
import com.lanou.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/10/24.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user;//接收表单提交的数据

    /**
     * 使用Spring的属性注解完成service层的装载
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    public String login(){
        if (userService.login(user.getLoginName(),user.getPassword())){
            return SUCCESS;
        }
        return ERROR;
    }

    /**
     * 针对登录动作进行的验证
     */
    public void validateLogin() {
        if (StringUtils.isBlank(user.getLoginName()) || StringUtils.isBlank(user.getPassword())){
            addActionError("用户名或密码不能为空,请重新输入!");
        }

    }

    @Override
    public User getModel() {
        user = new User();
        return user;//返回要接收数据的对象
    }
}
