package com.ccb.test.report.aop;

import com.ccb.test.report.configuration.MultiDataSource;
import com.ccb.test.report.vo.RequestVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DataSourceInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceInterceptor.class);

    @Pointcut("execution(* com.ccb.test.report.controller..*.*(..))")
    public void doAspect() {};

    @Around("doAspect()")
    public Object selectDataSource(ProceedingJoinPoint pj) throws Throwable{
        Object[] args = pj.getArgs();
        RequestVo requestVo = (RequestVo)args[0];
        System.out.println(requestVo.getEnv());
        logger.info("Switcht dataSource to " + requestVo.getEnv());
        MultiDataSource.setDataSourceKey(requestVo.getEnv());
        Object object = pj.proceed();
        return object;
    }
}
