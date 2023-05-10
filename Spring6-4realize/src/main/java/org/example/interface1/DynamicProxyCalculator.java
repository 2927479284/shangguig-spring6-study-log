package org.example.interface1;

/**
 * 计算器的动态代理类
 */
public class DynamicProxyCalculator {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CaiXuKun());
        Star proxy = (Star) proxyFactory.getProxy();
        proxy.changGe();
    }
}
