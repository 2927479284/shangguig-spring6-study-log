package org.example.annoAop;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类 用于Aop
 */
@Aspect // 表示当前类为一个切面类
@Component// 讲当前类注入到spring 为spring管理
@Log4j2
public class LogAspect {

    // 设置切入点 and 通知类型
    // 通知类型：
    //  (1)前置 @Before 在被代理的目标方法前执行
    //  (2)返回 @AfterReturning 在被代理的目标方法成功结束后执行（寿终正寝）
    //  (3)异常 @AfterThrowing 在被代理的目标方法异常结束后执行（死于非命）
    //  (4)后置 @After() 在被代理的目标方法最终结束后执行（盖棺定论）
    //  (5)环绕 @Around() 使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置

    /** 在被代理的目标方法前执行
     * (1)前置 @Before
     * execution(* org.example.annoAop.*.*(..))
     *  *：任意权限修饰符(public private protected)
     *  org.example.annoAop:包路径
     *  *:任意类
     *  *:任意方法
     *  ..:方法参数列表(这里..代表任意参数)
     */
    @Before(value = "execution(* org.example.annoAop.*.*(..))")
    public void testBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();// 被增强的方法名
        Object[] args = joinPoint.getArgs();// 被增强的方法的内置参数
        log.info("前置通知日志,方法名："+methodName+" 参数："+ Arrays.toString(args));
    }


    /** 在被代理的目标方法成功结束后执行（寿终正寝）
     * (2)返回 @AfterReturning
     * 可以获取到返回值
     * @param joinPoint 目标方法信息
     * @param result 目标方法返回值
     */
    @AfterReturning(value = "execution(* org.example.annoAop.*.*(..))",returning = "result")
    public void testAfterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();// 被增强的方法名
        Object[] args = joinPoint.getArgs();// 被增强的方法的内置参数
        log.info("返回通知日志,方法名："+methodName+" 参数："+ Arrays.toString(args) + " 返回值："+result);
    }


    /** 在被代理的目标方法异常结束后执行（死于非命）
     * (3)异常 @AfterThrowing 获取到目标方法异常信息
     * 目标方法出现异常，这个通知执行
     * @param joinPoint 目标方法信息
     * @param exception 具体的异常信息
     */
    @AfterThrowing(value = "execution(* org.example.annoAop.*.*(..))",throwing = "exception")
    public void testAfterThrowing(JoinPoint joinPoint,Throwable exception){
        String methodName = joinPoint.getSignature().getName();// 被增强的方法名
        Object[] args = joinPoint.getArgs();// 被增强的方法的内置参数
        log.info("异常通知日志,方法名："+methodName+" 参数："+ Arrays.toString(args) + " 异常信息："+exception.getMessage());
    }

    /** 在被代理的目标方法最终结束后执行（盖棺定论）
     * (4)后置 @After()
     * @param joinPoint 目标方法信息
     */
    @After(value = "execution(* org.example.annoAop.*.*(..))")
    public void testAfter(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();//被增强的方法名
        Object[] args = joinPoint.getArgs();// 被增强的方法参数列表
        log.info("后置通知日志,方法名："+methodName+" 参数："+ Arrays.toString(args));
    }

    /**
     * 使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所有位置
     * (5)环绕 @Around()
     * @param joinPoint 目标方法信息（环绕时增强 ProceedingJoinPoint）
     * @return 目标方法的执行，目标方法的返回值一定要返回给外界调用者
     */
    @Around(value = "execution(* org.example.annoAop.*.*(..))")
    public Object testAround(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            log.info("环绕通知[(1)前置 @Before]-->目标对象方法执行之前");
            //目标方法的执行，目标方法的返回值一定要返回给外界调用者
            result = joinPoint.proceed();
            log.info("环绕通知[(2)返回 @AfterReturning]-->目标对象方法【返回值】之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.info("环绕通知[(3)异常 @AfterThrowing]-->目标对象方法出现【异常】时");
        } finally {
            log.info("环绕通知[(4)后置 @After()]-->目标对象方法执行完毕");
        }
        return result;
    }


    /**
     * 重复使用execution
     */
    @Pointcut("execution(* org.example.annoAop.*.*(..))")
    public void pointCut(){}


    /** 在被代理的目标方法前执行 重复使用execution
     * (1)前置 @Before
     * execution(* org.example.annoAop.*.*(..))
     *  *：任意权限修饰符(public private protected)
     *  org.example.annoAop:包路径
     *  *:任意类
     *  *:任意方法
     *  ..:方法参数列表(这里..代表任意参数)
     */
//    @Before(value = "pointCut()")
//    public void testBefore1(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();// 被增强的方法名
//        Object[] args = joinPoint.getArgs();// 被增强的方法的内置参数
//        log.info("前置通知日志,方法名："+methodName+" 参数："+ Arrays.toString(args));
//    }

}
