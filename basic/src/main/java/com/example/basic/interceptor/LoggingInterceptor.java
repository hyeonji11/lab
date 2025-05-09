package com.example.basic.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalDateTime requestTime = LocalDateTime.now();
        log.info("[REQUEST] {} {} | 요청 시각 : {}", request.getMethod(), request.getRequestURI(), requestTime.format(FORMATTER));
//        log.info("[API LOG] Request Time: [{}]", requestTime.format(FORMATTER));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalDateTime responseTime = LocalDateTime.now();

        log.info("[RESPONSE] {} {} | 응답 시각 : {}", request.getMethod(), request.getRequestURI(), responseTime.format(FORMATTER));

//        log.info("[API LOG] {} Response Time: [{}]", request.getRequestURI(), responseTime.format(FORMATTER));
//        log.info("[API LOG] Response Status Code: [{}]", response.getStatus());
    }
}
