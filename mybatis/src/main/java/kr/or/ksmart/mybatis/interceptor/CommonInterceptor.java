package kr.or.ksmart.mybatis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {

		logger.info("CommonIterceptor ================================START");
		logger.info("ACCESS INFO =============================START");
		logger.info("Port   :::::: {}", request.getLocalPort());
		logger.info("ServerName   :::::: {}", request.getServerName());
		logger.info("getMethod   :::::: {}", request.getMethod());	
		logger.info("getRequestURI   :::::: {}", request.getRequestURI());
		logger.info("ACCESS INFO======================================END");
		return super.preHandle(request, response, handler);
		//return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("CommonIterceptor================================END");
		// TODO Auto-generated method stub
		//super.postHandle(request, response, handler, modelAndView);
	}
}
