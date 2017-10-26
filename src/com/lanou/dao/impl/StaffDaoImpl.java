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
        int postId = (int) params.get("postId");
        String name = (String) params.get("name");
        String hql = "from Staff where 1=1";
        StringBuffer stringBuffer = new StringBuffer(hql);

        if (postId!=-1){
            stringBuffer.append(" and postID like :postId");
        }else {
            params.remove("postId");
        }
        if (name!=null){
            stringBuffer.append(" and staffName like :name");
        }
        return super.find(stringBuffer.toString(),params);
    }
}
