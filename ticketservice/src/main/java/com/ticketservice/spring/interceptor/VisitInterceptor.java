package com.ticketservice.spring.interceptor;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-12-10
 */


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
// 拦截器需要在配置类中注册
public class VisitInterceptor implements HandlerInterceptor {
    //    目标方法执行之前调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		跨域访问
		response.setHeader("Access-Control-Allow-Headers",request.getHeader("Access-Control-Request-Headers"));
//        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
//		允许所有的域名跨域访问，使用 * 通常无效
//		response.setHeader("Access-Control-Allow-Origin","*");
//      允许使用任意的域名进行访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        /**
         * Response to preflight request doesn't pass access control check:
         * The value of the 'Access-Control-Allow-Credentials' header in the response is '' which
         * must be 'true' when the request's credentials mode is 'include'.
         **/
        //前端请求设置credentials: 'include', 这里就必须设置为true
        response.setHeader("Access-Control-Allow-Credentials","true");
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
        String AUTHORIZATION = request.getHeader("AUTHORIZATION");
        System.out.println("AUTHORIZATION = " + AUTHORIZATION);
//        Object username = request.getSession().getAttribute("username");
//        if(username==null){
//            System.out.println("用户没有登录:"+ LocalDateTime.now().toLocalTime().toString());
//            response.setHeader("Content-Type", "text/html;charset=UTF-8");
//            response.getWriter().write("需要登录才能进行登录操作！<a href=\"login.html\">点此登录</a>");
//            return false;
//        }

        return true;
    }
    //    方法执行完成后，视图返回前调用
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle...");
//    }
    //   视图返回之后调用
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        System.out.println("afterCompletion...");
//    }

}
