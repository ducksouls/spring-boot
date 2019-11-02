package cn.lai.springannotation.aop;

/**
 * @Description:
 * @author: ZNXM-007
 * @date 2019/11/2 16:59
 */

import org.aspectj.lang.annotation.*;

/**
 * 下面的都是通知方法...
 */
@Aspect
public class LogAspect {

    /**
     * 抽取公共的切入点
     */
    @Pointcut("execution(public double cn.lai.springannotation.service.DivideZero.*(..))")
    public void pointCunt(){};


    /**
     * 前置通知,
     * @Before 是切入时机,后面的value是aspectj表达式,用来指定切入点
     */
    @Before( "execution(public double cn.lai.springannotation.service.DivideZero.*(double,double))" )
    public void logStart() {
        System.out.println("除法运行,参数列表---{}");
    }

    /**
     * 后置通知
     */
    @After("pointCunt()")
    public void logEnd() {
        System.out.println("除法结束---");
    }

    /**
     * 返回通知
     */
    @AfterReturning("pointCunt()")
    public void logReturn () {
        System.out.println("除法正常,返回值是---{}");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pointCunt()")
    public  void logException() {
        System.out.println("除法异常,信息---{}");
    }
    /**
     * 环绕通知: 动态代理,手动推进目标方法运行
     */

}
