package com.project.common.encode;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TranscodingAspect {





    @Pointcut("@annotation(analysisActuator)")
    public void serviceStatistics(Transcoding analysisActuator) {
    }

    @Before("serviceStatistics(analysisActuator)")
    public void doBefore(JoinPoint joinPoint, Transcoding analysisActuator) {
        // 记录请求到达时间

    }

    @After("serviceStatistics(analysisActuator)")
    public void doAfter(Transcoding analysisActuator) {


    }



}
