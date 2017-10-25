package com.lanou.test;

import com.lanou.domain.HR.Department;
import com.lanou.domain.HR.Post;
import com.lanou.domain.HR.Staff;
import com.lanou.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by dllo on 17/10/24.
 */
public class UserTest {

    private ApplicationContext context;


    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void saveUser(){
      SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) context.getBean("user");
        session.save(user);
        transaction.commit();
    }

    @Test
    public void saveHR(){
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Department department = new Department("教学部");
        Post post = new Post("java讲师");
        Post post1 = new Post("IOS讲师");
        department.getPosts().add(post);
        department.getPosts().add(post1);
        session.save(department);

        Department department1 = new Department("职规部");
        Post post2 = new Post("职规主管");
        Post post3 = new Post("班主任");
        department1.getPosts().add(post2);
        department1.getPosts().add(post3);
        session.save(department1);


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
}
