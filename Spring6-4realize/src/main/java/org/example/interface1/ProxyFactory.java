package org.example.interface1;

import java.lang.reflect.Proxy;

/**
 * 动态代理生成工厂
 */

public class ProxyFactory {

    public Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    /**
     * 返回对应动态代理
     * @return
     */
    public Object getProxy(){
        ClassLoader classLoader = object.getClass().getClassLoader();//对应类的加载器
        Class<?>[] interfaces = object.getClass().getInterfaces();//对应class的实现接口合集
        return Proxy.newProxyInstance(classLoader, interfaces, (proxy, method, args) -> {
            System.out.println("方法执行前日志");
            Object invoke = method.invoke(object, args);
            System.out.println("方法执行后日志");
            return invoke;
        });
    }
}
