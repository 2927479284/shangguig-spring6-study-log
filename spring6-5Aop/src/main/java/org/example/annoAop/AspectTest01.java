package org.example.annoAop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 切面测试类
 */
public class AspectTest01 {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(1,1);
        //bean.addThrowException(1,1);
    }



    public void test02(){

    }
}
