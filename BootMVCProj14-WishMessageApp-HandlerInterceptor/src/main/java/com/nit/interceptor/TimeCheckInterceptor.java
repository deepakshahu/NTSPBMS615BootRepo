package com.nit.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		System.out.println("TimeCheckInterceptor.preHandle()");
		//get system date and time
		LocalDateTime ldt = LocalDateTime.now();
		//get current hour of the day
		int hour = ldt.getHour();
		if(!req.getServletPath().equalsIgnoreCase("/"))
			if(hour<9 || hour>15) {
				RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
				rd.forward(req, res);
				return false;
			}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TimeCheckInterceptor.postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TimeCheckInterceptor.afterCompletion()");
	}
}
