package org.example.annoAop;

/**
 * 自定义一个接口
 * 计算器
 */
public interface Calculator {

    int add(int i, int j);

    int sub(int i, int j);

    int mul(int i, int j);

    int div(int i, int j);

    /**
     * 加法预算手动抛出一个异常
     * @param i 前值
     * @param j 后值
     * @return
     */
    int addThrowException(int i,int j);
}
