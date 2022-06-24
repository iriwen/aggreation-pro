package com.manjaro.code.interceptor;



import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * iriwen
 */

public class MyReqInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if(!(handler instanceof HandlerMethod)){
			if(handler instanceof ResourceHttpRequestHandler){
				System.out.println("对http  resource 进行拦截");
			}
			return true ;
		} else {
			System.out.println(" prehandle intercept req path:"+ request.getServletPath());
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						    ModelAndView modelAndView){
		System.out.println("enter MyReqInterceptor  postHandle intercept .....");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("req end , MyReqInterceptor  afterCompletion intercept!!");
	}
}
