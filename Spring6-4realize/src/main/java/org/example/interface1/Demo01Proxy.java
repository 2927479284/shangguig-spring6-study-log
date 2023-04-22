package org.example.interface1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 蔡徐坤动态代理测试
 */
public class Demo01Proxy {
    public static void main(String[] args) {
        //没有对蔡徐坤进行代理,创建蔡徐坤对象,调用蔡徐坤的功能
        CaiXuKun cxk = new CaiXuKun();
        //cxk.changGe();
        //cxk.tiaoWu();

        //生成蔡徐坤的代理人对象
        Star cxkProxy = (Star)Proxy.newProxyInstance(cxk.getClass().getClassLoader(), cxk.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                        invoke:起到拦截作用,调用蔡徐坤的方法,都会被invoke所拦截
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //获取到拦截的方法名称
                        String name = method.getName();
                        //System.out.println(name);
                        //打印拦截到的方法的参数
                        //System.out.println(Arrays.toString(args));

                        //判断方法名称是否为唱歌方法,是,对唱歌方法进行增强
                        if("changGe".equals(name)){
                            System.out.println("安排蔡徐坤开一场演唱会,给粉丝唱歌");
                            return null;//结束方法
                        }

                        //判断方法名称是否为跳舞的方法,是,抛出异常,不让方法运行
                        if("tiaoWu".equals(name)){
                            throw new RuntimeException("蔡徐坤生病了,不能跳舞!");
                        }

                        //调用是蔡徐坤的其他的方法,代理人同意了,就可以继续运行方法(使用反射)
                        Object v = method.invoke(cxk, args);
                        return v;
                    }
                });
        //蔡徐坤的代理人,对蔡徐坤进行代理,调用蔡徐坤的功能通过代理人调用
        //cxkProxy.changGe();
        //String s = cxkProxy.zhiBoDaiHuo(1);
        //System.out.println(s);
        //cxkProxy.tiaoWu();//RuntimeException: 蔡徐坤生病了,不能跳舞!
    }
}
