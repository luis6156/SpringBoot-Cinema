package com.cinema.app.audit;

import org.aspectj.lang.JoinPoint;

public interface AuditAspect {
    void logBeforeMethod(JoinPoint joinPoint);

    void logAfterMethod(JoinPoint joinPoint, Object result);

    void logException(JoinPoint joinPoint, Exception ex);
}
