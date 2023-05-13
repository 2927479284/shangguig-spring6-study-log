package org.example.junit.junit5;

import jdk.jfr.Experimental;
import org.example.junit.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * spring整合junit5测试
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(value = "classpath:beans.xml")
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class SpringTestJunit5 {

    @Autowired
    private User user;


    @Test
    public void test01(){
        System.out.println("spring整合junit5测试");
        user.run();
    }
}
