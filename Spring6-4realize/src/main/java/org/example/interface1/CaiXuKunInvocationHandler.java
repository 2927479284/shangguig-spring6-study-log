package org.example.interface1;

import org.example.zhujie.Bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 蔡徐坤的动态代理拦截器
 */
@Bean
public class CaiXuKunInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("changGe")){
            System.out.println("对当前方法进行了增强");
        }
        return null;
    }
}
