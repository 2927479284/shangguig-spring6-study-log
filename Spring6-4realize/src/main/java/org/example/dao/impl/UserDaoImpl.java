package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.zhujie.Bean;


@Bean
public class UserDaoImpl implements UserDao {


    @Override
    public void add(){
        System.out.println("userDao测试add方法");
    }
}
