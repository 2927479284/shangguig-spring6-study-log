package org.example;

import org.example.domain.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanReaderTest {



    @Test
    public void reader(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //1.通过id获取
        UserEntity user = (UserEntity) applicationContext.getBean("user");
        UserEntity user1 = (UserEntity) applicationContext.getBean("user1");
        user.setUserName("user");
        System.out.println(user);
        System.out.println(user1);
/*        //2.通过类型获取
        UserEntity bean = applicationContext.getBean(UserEntity.class);
        //3.通过ID+类型获取
        UserEntity bean1 = applicationContext.getBean("user", UserEntity.class);*/

    }
}
