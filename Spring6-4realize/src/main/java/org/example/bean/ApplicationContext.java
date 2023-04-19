package org.example.bean;

/**
 * 自定义ioc容器
 */
public interface ApplicationContext {

    public Object getBean(Class<?> clazz);
}
