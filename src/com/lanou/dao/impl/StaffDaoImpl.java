package com.lanou.dao.impl;

import com.lanou.dao.StaffDao;
import com.lanou.dao.impl.BaseDaoImpl;
import com.lanou.domain.hr.Staff;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {


    @Override
    public List<Staff> findStaff(Map<String, Object> params) {
        Object postId = params.get("postId");
        String name = (String) params.get("name");

        String hql = "from Staff where 1=1";
        StringBuffer stringBuffer = new StringBuffer(hql);

        if (!postId.equals("-1")){
            stringBuffer.append(" and postID like :postId");
        }else {
            params.remove("postId");
        }
        if (name!=null){
            stringBuffer.append(" and staffName like :name");

        }
        return super.find(stringBuffer.toString(),params);
    }

    @Override
    public List<Staff> login(String loginName) {
        Session session = currentSession();
        Query query = session.createQuery(" from Staff where loginName=:na");
        //设置参数
        query.setParameter("na",loginName);
        List<Staff> staffs = query.list();
        return staffs;

    }
}
