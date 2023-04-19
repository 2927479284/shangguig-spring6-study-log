package org.example.service;


import org.example.Dao.UserDao;
import org.example.Dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDaoImpl userDao;
    @Override
    public void addService() {
        System.out.println("service add方法执行成功");
        userDao.addDao();
    }
}
