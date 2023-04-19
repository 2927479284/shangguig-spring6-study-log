package org.example;

import org.example.bean.impl.AnnotationApplicationContext;
import org.example.controller.UserController;
import org.example.interface1.Calculator;
import org.example.interface1.CalculatorImpl;
import org.example.interface1.CalculatorStaticProxy;

/**
 * 手写 IOC容器 实现控制反转 依赖注入
 */
public class Main {
    public static void main(String[] args) {
        AnnotationApplicationContext annotationApplicationContext = new AnnotationApplicationContext("org.example");
        UserController bean = (UserController) annotationApplicationContext.getBean(UserController.class);
        //bean.add();
        Calculator calculator = (Calculator) annotationApplicationContext.getBean(Calculator.class);
        //calculator.add(1,2);
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
        calculatorStaticProxy.add(1,1);
    }

}