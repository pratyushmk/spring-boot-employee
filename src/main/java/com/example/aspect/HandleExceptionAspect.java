package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HandleExceptionAspect {
    @Pointcut("within(com.example.*)")
    public void exceptionHandlingAspect(){}

//    @Around("exceptionHandlingAspect()")
//public void methodArgumentNotValidExceptionHandlingAdvice(ProceedingJoinPoint jointPoint) throws Throwable {

    @AfterThrowing(value="exceptionHandlingAspect()", throwing = "exception")
    public void methodArgumentNotValidExceptionHandlingAdvice(JoinPoint jointPoint, Throwable exception) {
        System.out.println("within aspect");
        System.out.println(exception);
        String className = jointPoint.getSignature().getDeclaringType().getName();
        String methodName = jointPoint.getSignature().getName();
        Object[] args = jointPoint.getArgs();
        System.out.println(className);
        System.out.println(methodName);
        System.out.println(args);

//        try {
//            jointPoint.proceed();
//        }catch (MethodArgumentNotValidException ex) {
//            throw new RuntimeException("Invalid parameter passed in");
//        }
    }
}
