package com.lanou.test;

import com.lanou.domain.hr.Department;
import com.lanou.domain.hr.Post;
import com.lanou.domain.hr.Staff;
import com.lanou.domain.tr.Classes;
import com.lanou.domain.tr.CourseType;
import com.lanou.util.CipherUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Created by dllo on 17/10/24.
 */
public class HRTest {

    private ApplicationContext context;


    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void saveHR() {
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


        Staff staff = new Staff("大师", "123", "吴大师", "男", new Date());
        staff.setDepartment(department);
        staff.setPost(post);
        session.save(staff);

        Staff staff1 = new Staff("武神", "123", "武奇", "男", new Date());
        staff1.setDepartment(department);
        staff1.setPost(post);
        session.save(staff1);

        Staff staff2 = new Staff("封神", "123", "丰神", "女", new Date());
        staff2.setDepartment(department);
        staff2.setPost(post1);
        session.save(staff2);

        Staff staff3 = new Staff("湃湃", "123", "王湃", "女", new Date());
        staff3.setDepartment(department1);
        staff3.setPost(post3);
        session.save(staff3);

        Staff staff4 = new Staff("欣姐", "123", "何欣", "女", new Date());
        staff4.setDepartment(department1);
        staff4.setPost(post3);
        session.save(staff4);

        Staff staff5 = new Staff("琳琳", "123", "马琳", "女", new Date());
        staff5.setDepartment(department1);
        staff5.setPost(post2);
        session.save(staff5);

        transaction.commit();
    }

    @Test
    public void findPost() {
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
    public void cipher() {
        String pw1 = "123";
        String pw2 = "";
        CipherUtil cipherUtil = new CipherUtil();
        pw2 = cipherUtil.generatePasswprd(pw1);
        System.out.println("加密后" + pw2);

        if (cipherUtil.validatePasword(pw2, pw1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

    public class Md5Util {
        /**
         * 对字符串md5加密
         *
         * @param str
         * @return
         */
        public String getMD5(String str) {
            try {
                // 生成一个MD5加密计算摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 计算md5函数
                md.update(str.getBytes());
                // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
                // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                return new BigInteger(1, md.digest()).toString(16);
            } catch (Exception e) {
                return null;
            }
        }

        /**
         * 对字符串md5加密
         *
         * @param str
         * @return
         */
        public String getMD5For32(String str) {
            String re = null;
            byte encrypt[];
            try {
                byte[] tem = str.getBytes();
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.reset();
                md5.update(tem);
                encrypt = md5.digest();
                StringBuilder sb = new StringBuilder();
                for (byte t : encrypt) {
                    String s = Integer.toHexString(t & 0xFF);
                    if (s.length() == 1) {
                        s = "0" + s;
                    }
                    sb.append(s);
                }
                re = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return re;
        }
    }

    @Test
    public void test() {
        String str = "123";
        Md5Util md5Util = new Md5Util();
        System.out.println(md5Util.getMD5(str));
        System.out.println(md5Util.getMD5For32(str));
    }

    @Test

    public void saveTR() {
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CourseType courseType = new CourseType(18800.0, 60, "java", "棒棒的");
        session.save(courseType);
        CourseType courseType1 = new CourseType(19800.0, 80, "H5", "棒棒哒");
        session.save(courseType1);

        String time = "2017-6-6";
        String time1 = "2017-12-6";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        try {
            Date date = sdf.parse(time);
            Date date1 = sdf.parse(time1);
            Classes classes = new Classes("001", date, date1, "开班", 40, 3, 2, 5, "好好学习");
            classes.setCourseType(courseType);
            session.save(classes);
            Classes classes1 = new Classes("002", date, date1, "开班", 30, 2, 4, 3, "天天向上");
            classes1.setCourseType(courseType1);
            session.save(classes1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        transaction.commit();

    }


    @Test
    public void time() {
        String time ="2017-10-2";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        try {
            Date date = sdf.parse(time);
            System.out.println(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}



