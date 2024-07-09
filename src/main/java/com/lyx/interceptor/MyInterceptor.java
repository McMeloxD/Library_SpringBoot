package com.lyx.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/4
 * @desc
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 前置拦截器(目标处理器前执行此方法)
     * 一般做前置校验/编码格式设置
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  目标处理器(目标Controller)
     * @return 布尔值, true是放行, false是不放行
     * @throws Exception 目标Controller的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("user") != null) {
            //如果已登录那就放行
            return true;
        }
        //未登录跳转
        response.sendRedirect("/index.html");
        return false;
    }

    /**
     * 目标处理器执行完后执行此方法
     * <p>
     * 是在目标方法正常执行后执行,目的是对目标方法返回的数据和页面进行再处理
     * 但是,现在前后端分离后,返回的JSON,没有ModelAndView,
     * 所以这个将来一般不用重写
     *
     * @param handler      目标Controller
     * @param modelAndView 目标Controller返回的数据
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    /**
     * 目标处理器执行完后执行此方法
     * <p>
     * 目标方法无论有无报错,都会执行
     * 如果目标方法没有报错,参数ex是null
     * 如果目标方法报错,参数ex是就是异常信息
     * 因为这个方法afterCompletion,目标方法无论有无报错,都会执行,所以呢
     * 一般用于后续"打扫战场",类似于finally,处理一些资源关联等.....
     *
     * @param ex 目标方法如果有异常,这个就是异常对象
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
