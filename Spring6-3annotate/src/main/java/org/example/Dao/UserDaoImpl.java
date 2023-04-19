package org.example.Dao;


import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void addDao() {
        System.out.println("Dao add方法执行成功");
    }
}
