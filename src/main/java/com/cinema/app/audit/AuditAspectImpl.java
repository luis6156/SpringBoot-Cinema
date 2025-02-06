package com.cinema.app.audit;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspectImpl implements AuditAspect {
    private static final Logger logger = LoggerFactory.getLogger(AuditAspectImpl.class);

    private final AuditRepository auditRepository;

    @Before("execution(* com.cinema.app..*(..))")
    @Override
    public void logBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Executing method: {} with arguments: {}", methodName, Arrays.toString(args));
    }

    @AfterReturning(pointcut = "execution(* com.cinema.app..*(..))", returning = "result")
    @Transactional
    @Override
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        // Skip if the result is an Audit entity (to prevent recursion)
        if (result instanceof Audit) {
            return;
        }

        String methodName = joinPoint.getSignature().getName();
        String action = "Executed " + methodName;
        String details = (result != null) ? "Returned result: " + result : "No return value";

        String user = "currentUser"; // Replace with actual user retrieval logic

        Audit audit = new Audit();
        audit.setEntity(joinPoint.getTarget().getClass().getName());
        audit.setAction(action);
        audit.setDetails(details);
        audit.setTimestamp(LocalDateTime.now());
        audit.setUser(user);

        auditRepository.save(audit);
    }

    @AfterThrowing(pointcut = "execution(* com.cinema.app..*(..))", throwing = "ex")
    @Override
    public void logException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Method: {} threw an exception: {}", methodName, ex.getMessage());
    }
}

