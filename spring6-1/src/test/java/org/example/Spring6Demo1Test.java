package org.example;

import org.example.domain.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring6Demo1Test {


    /**
     * 通过spring 获取出对应的对象
     * 单例
     */
    @Test
    public void beanIoc(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserEntity userEntity = (UserEntity) applicationContext.getBean("userEntity");
        userEntity.setId("1");
        userEntity.setUserName("张三");
        userEntity.setPassWord("123456");
        userEntity.setUserMessage("用户消息字段");
        System.out.println(userEntity);
        UserEntity userEntity1 = (UserEntity) applicationContext.getBean("userEntity");
        System.out.println(userEntity1);
    }


    /**
     * 原理
     */
    @Test
    public void principle() throws Exception{
        Class<?> aClass = Class.forName("org.example.domain.UserEntity");
        //Object o1 = aClass.newInstance(); JDK19 弃用
        UserEntity o = (UserEntity) aClass.getDeclaredConstructor().newInstance();
        System.out.println(o);
    }
}
