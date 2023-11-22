package com.gugu.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

//https://www.cnblogs.com/tanxj/p/17414893.html

@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
    // 白名单，不校验权限
    List<String> writeList = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截器进行鉴权
        String requestURI = request.getRequestURI();
        if (writeList.contains(requestURI)){
            return true;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
