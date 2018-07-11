package advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * Created by xixi on 2018/7/5.
 */
public class SpeakAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("--------------Method Start--------------");
        Date begin=new Date();
        //继续执行业务代码
        Object obj=methodInvocation.proceed();
        System.out.println("--------------Method END--------------");
        Date end=new Date();

        System.out.println("程序运行的时间"+(end.getTime()-begin.getTime())+"ms");
        return obj;
    }
}
