package org.example.annoAop;


import org.springframework.stereotype.Component;

/**
 * 计算器接口的实现类
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        int result = i + j;

        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int addThrowException(int i, int j) {
        int result = i + j;

        System.out.println("方法内部 result = " + result);
        try {
            int a = 10/0;
        }catch (Exception e) {
            throw new RuntimeException("自己手动抛出了一个异常");
        }
        return result;
    }
}
