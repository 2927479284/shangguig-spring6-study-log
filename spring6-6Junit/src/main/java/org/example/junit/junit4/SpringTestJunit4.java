package org.example.junit.junit4;


import org.example.junit.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 整合 junit4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:beans.xml")
public class SpringTestJunit4 {


    @Autowired
    private User user;

    @Test
    public void test01(){
        System.out.println("Spring 整合 junit4");
        user.run();
    }
}
