package com.lifeskill.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class StudentActivityLoggingAspect {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.isAuthenticated() ? auth.getName() : "anonymous";
    }

    @Around("execution(* com.lifeskill.controller.ParticipationController.*(..))")
    public Object logParticipationActivity(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = getCurrentUsername();
        String method = joinPoint.getSignature().getName();
        String timestamp = LocalDateTime.now().format(FORMATTER);

        log.info("[학생활동] 시작 | 시간: {} | 사용자: {} | 액션: {}", timestamp, username, method);

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - startTime;
            log.info("[학생활동] 완료 | 사용자: {} | 액션: {} | 소요시간: {}ms", username, method, duration);
            return result;
        } catch (Throwable e) {
            long duration = System.currentTimeMillis() - startTime;
            log.error("[학생활동] 실패 | 사용자: {} | 액션: {} | 소요시간: {}ms | 에러: {}", username, method, duration, e.getMessage());
            throw e;
        }
    }

    @Around("execution(* com.lifeskill.controller.ActivityController.*(..))")
    public Object logActivityBrowsing(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = getCurrentUsername();
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String timestamp = LocalDateTime.now().format(FORMATTER);

        log.info("[활동조회] 시작 | 시간: {} | 사용자: {} | 액션: {} | 파라미터: {}", timestamp, username, method, Arrays.toString(args));

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - startTime;
            log.info("[활동조회] 완료 | 사용자: {} | 액션: {} | 소요시간: {}ms", username, method, duration);
            return result;
        } catch (Throwable e) {
            long duration = System.currentTimeMillis() - startTime;
            log.error("[활동조회] 실패 | 사용자: {} | 액션: {} | 소요시간: {}ms | 에러: {}", username, method, duration, e.getMessage());
            throw e;
        }
    }

    @Around("execution(* com.lifeskill.controller.GradeController.*(..)) || " +
            "execution(* com.lifeskill.controller.UnitController.*(..)) || " +
            "execution(* com.lifeskill.controller.CategoryController.*(..))")
    public Object logCurriculumBrowsing(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = getCurrentUsername();
        String method = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        String timestamp = LocalDateTime.now().format(FORMATTER);

        log.info("[커리큘럼조회] 시작 | 시간: {} | 사용자: {} | 액션: {} | 파라미터: {}", timestamp, username, method, Arrays.toString(args));

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - startTime;
            log.info("[커리큘럼조회] 완료 | 사용자: {} | 액션: {} | 소요시간: {}ms", username, method, duration);
            return result;
        } catch (Throwable e) {
            long duration = System.currentTimeMillis() - startTime;
            log.error("[커리큘럼조회] 실패 | 사용자: {} | 액션: {} | 소요시간: {}ms | 에러: {}", username, method, duration, e.getMessage());
            throw e;
        }
    }

    @Around("execution(* com.lifeskill.controller.AuthController.*(..))")
    public Object logAuthActivity(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String timestamp = LocalDateTime.now().format(FORMATTER);

        log.info("[인증] 시작 | 시간: {} | 액션: {}", timestamp, method);

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - startTime;
            log.info("[인증] 완료 | 액션: {} | 소요시간: {}ms", method, duration);
            return result;
        } catch (Throwable e) {
            long duration = System.currentTimeMillis() - startTime;
            log.error("[인증] 실패 | 액션: {} | 소요시간: {}ms | 에러: {}", method, duration, e.getMessage());
            throw e;
        }
    }

    @Around("execution(* com.lifeskill.controller.UserController.*(..))")
    public Object logUserActivity(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = getCurrentUsername();
        String method = joinPoint.getSignature().getName();
        String timestamp = LocalDateTime.now().format(FORMATTER);

        log.info("[사용자] 시작 | 시간: {} | 사용자: {} | 액션: {}", timestamp, username, method);

        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - startTime;
            log.info("[사용자] 완료 | 사용자: {} | 액션: {} | 소요시간: {}ms", username, method, duration);
            return result;
        } catch (Throwable e) {
            long duration = System.currentTimeMillis() - startTime;
            log.error("[사용자] 실패 | 사용자: {} | 액션: {} | 소요시간: {}ms | 에러: {}", username, method, duration, e.getMessage());
            throw e;
        }
    }
}
