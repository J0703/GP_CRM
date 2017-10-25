package com.lanou.dao.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.HR.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {

    @Override
    public List<Staff> findStaff(Map<String, Object> params) {
        Object depId= params.get("depId");
        Object postId = params.get("postId");
        Object name = params.get("name");
        String hql = "from Staff where 1=1";
        StringBuffer stringBuffer = new StringBuffer(hql);
        if (!depId.toString().equals("-1")){
            stringBuffer.append(" and depID like :depId");
        }else {
            params.remove("depId");
        }
        if (!postId.toString().equals("-1")){
            stringBuffer.append(" and postID like :postId");
        }else {
            params.remove("postId");
        }
        if (name.toString()!=null){
            stringBuffer.append(" and staffName like :name");
        }else {
            params.remove("name");
        }
        return super.find(stringBuffer.toString(),params);
    }
}
