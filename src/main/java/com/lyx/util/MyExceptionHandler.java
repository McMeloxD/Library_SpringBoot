package com.lyx.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/9
 * @desc 全局处理异常
 */

@ControllerAdvice // 对控制层异常的处理
public class MyExceptionHandler {
    /**
     * 自己定义方法,完成处理异常的逻辑
     * @ExceptionHandler这个注解,默认能处理(发现)任意类型异常
     *
     * 如果注解中,设置了异常类型,那就只处理指定异常
     *
     * 返回值可以是页面路径
     */
    // @ExceptionHandler(NullPointerException.class) // 只处理NullPointerException异常
    // @ExceptionHandler // 处理所有异常
    // public String handlerException(Exception ex){
    //     System.out.println("出错啦!" + ex.getMessage());
    //     return "404.html";
    // }

    // 也可以返回给前端JSON
    //eturn R.fail();


    @ExceptionHandler
    public String handlerException(Exception ex){
        //注意这儿要自己new一个ModelAndView对象，不能直接在方法参数BusinessException e后写ModelAndView mv
        System.out.println("出错啦!" + ex.getMessage());
        return "forward:/404.html";
    }
}
