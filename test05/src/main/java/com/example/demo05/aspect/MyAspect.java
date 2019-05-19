package com.example.demo05.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@Aspect
public class MyAspect {
    /**
     * 计算所有buy前缀方法的执行实现
     * @param joinpoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.example..*.buy*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint joinpoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinpoint.proceed();
        long end = System.nanoTime();
        log.debug("方法：{}()，的执行时间：{}", joinpoint.getSignature().getName(), end - start);
        return result;
    }
    //@within意思是凡是带有注解myInterceptor均要执行（触发）以下方法
    @Around("@within(myInterceptor) || @annotation(myInterceptor)")
    public Object interecptorTarget(ProceedingJoinPoint joinpoint, MyIntercetor myInterceptor) throws Throwable {
        Optional.ofNullable(myInterceptor)
                .or(() -> {
                    MyIntercetor m =
                            joinpoint.getTarget().getClass().getAnnotation(MyIntercetor.class);
                    return Optional.of(m);
                })
                .ifPresent(m -> {
                    for (MyIntercetor.AuthorityType t : m.value()) {
                        log.debug("当前执行方法的权限：{}", t);
                    }
                });
        return joinpoint.proceed();
    }
}
