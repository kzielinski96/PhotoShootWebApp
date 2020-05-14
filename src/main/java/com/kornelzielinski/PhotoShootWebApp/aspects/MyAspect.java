package com.kornelzielinski.PhotoShootWebApp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class MyAspect {

    private static final Logger LOG = LoggerFactory.getLogger(MyAspect.class);
    private final String CONTROLLERS_POINTCUT = "execution(* com.kornelzielinski.PhotoShootWebApp.web.*.*(..))";

    @Before(CONTROLLERS_POINTCUT)
    public void logBefore(JoinPoint joinPoint) {
        LOG.info("[METHOD] --------> {}", joinPoint.getSignature().toShortString());

        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            LOG.info("[ARGS] --------> {}: {}", signatureArg.getClass().getSimpleName(),
                    signatureArg.toString());
        }
    }

    @After(CONTROLLERS_POINTCUT)
    public void logAfter(JoinPoint joinPoint) {
        LOG.info("[ENDED METHOD] --------> {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = CONTROLLERS_POINTCUT, returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        LOG.info("[ENDED METHOD] --------> {}, [RETURNING] --------> {}", joinPoint.getSignature().toShortString(), result);
    }

    @Around(CONTROLLERS_POINTCUT)
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant startTime = Instant.now();
        Object object = joinPoint.proceed();
        Instant endTime = Instant.now();

        LOG.info("[TIME TOOK] --------------------> {}, time: {} {} ", joinPoint.getSignature().toShortString(),
                Duration.between(startTime, endTime).toMillis(), "ms");

        return object;
    }
}
