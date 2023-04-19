package org.example.controller;

import org.example.bean.impl.AnnotationApplicationContext;
import org.example.dao.UserDao;
import org.example.zhujie.Bean;
import org.example.zhujie.Di;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {


    @Di
    private UserDao userDao;


    public void add(){
        System.out.println("userController add方法执行成功");
        userDao.add();
    }


    @Test
    public void test1(){
        AnnotationApplicationContext annotationApplicationContext = new AnnotationApplicationContext("org.example");
        Object bean = annotationApplicationContext.getBean(UserDao.class);
        userDao.add();
    }
}
