package com.lanou.test;

import com.lanou.domain.hr.Department;
import com.lanou.domain.hr.Post;
import com.lanou.domain.hr.Staff;
import com.lanou.util.CipherUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by dllo on 17/10/24.
 */
public class HRTest {

    private ApplicationContext context;


    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }
    @Test
    public void saveHR(){
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Department department = new Department("教学部");
        session.save(department);

        Department department1 = new Department("职规部");
        session.save(department1);

        Post post = new Post("java讲师");
        post.setDepartment(department);
        session.save(post);

        Post post1 = new Post("IOS讲师");
        post1.setDepartment(department);
        session.save(post1);


        Post post2 = new Post("职规主管");
        post2.setDepartment(department1);
        session.save(post2);

        Post post3 = new Post("班主任");
        post3.setDepartment(department1);
        session.save(post3);


        Staff staff = new Staff("大师","123","吴大师","男",new Date());
        staff.setDepartment(department);
        staff.setPost(post);
        session.save(staff);

        Staff staff1 = new Staff("武神","123","武奇","男",new Date());
        staff1.setDepartment(department);
        staff1.setPost(post);
        session.save(staff1);

        Staff staff2 = new Staff("封神","123","丰神","女",new Date());
        staff2.setDepartment(department);
        staff2.setPost(post1);
        session.save(staff2);

        Staff staff3 = new Staff("湃湃","123","王湃","女",new Date());
        staff3.setDepartment(department1);
        staff3.setPost(post3);
        session.save(staff3);

        Staff staff4 = new Staff("欣姐","123","何欣","女",new Date());
        staff4.setDepartment(department1);
        staff4.setPost(post3);
        session.save(staff4);

        Staff staff5 = new Staff("琳琳","123","马琳","女",new Date());
        staff5.setDepartment(department1);
        staff5.setPost(post2);
        session.save(staff5);

        transaction.commit();
    }

    @Test
    public void findPost(){
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Post";
        Query query = session.createQuery(hql);
        List lists = query.list();

        System.out.println(lists);
        transaction.commit();
    }

    @Test
    public  void cipher(){
        String pw1 = "123";
        String pw2="";
        CipherUtil cipherUtil = new CipherUtil();
       pw2 = cipherUtil.generatePasswprd(pw1);
        System.out.println("加密后" + pw2);

        if (cipherUtil.validatePasword(pw2,pw1)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }
}



