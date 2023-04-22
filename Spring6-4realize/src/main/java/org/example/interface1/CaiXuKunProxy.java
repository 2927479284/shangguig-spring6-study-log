package org.example.interface1;

import org.example.bean.impl.AnnotationApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 蔡徐坤的动态代理
 */
public class CaiXuKunProxy {

    public static void main(String[] args) {
        AnnotationApplicationContext annotationApplicationContext = new AnnotationApplicationContext("org.example");
        CaiXuKunInvocationHandler bean = (CaiXuKunInvocationHandler) annotationApplicationContext.getBean(InvocationHandler.class);
        CaiXuKun caiXuKun = new CaiXuKun();
        ClassLoader classLoader = caiXuKun.getClass().getClassLoader();//蔡徐坤类加载器
        Class<?>[] interfaces = caiXuKun.getClass().getInterfaces();//蔡徐坤当前类实现的接口集合
        Star o = (Star) Proxy.newProxyInstance(classLoader, interfaces, bean);
        o.changGe();
    }
}
