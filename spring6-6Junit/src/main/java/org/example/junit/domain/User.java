package org.example.junit.domain;

import org.springframework.stereotype.Component;

@Component
public class User {

    public void run(){
        System.out.println("user类中的 run方法执行成功");
    }
}
