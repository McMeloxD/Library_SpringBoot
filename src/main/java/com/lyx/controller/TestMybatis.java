package com.lyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Controller
public class TestMybatis {
        @PostMapping("/req1")
        public String test1() {
            System.out.println("接收请求1" );
            return "ok.html";
        }

        // @RequestMapping(value = "/req2",method = RequestMethod.GET)
        @GetMapping("/req2")
        public String test2() {
            System.out.println("接收请求2" );
            return "ok.html";
        }

    // @RequestMapping(value = "/req2",method = RequestMethod.GET)
    @GetMapping("/json")
    @ResponseBody
    public String test3() {
        System.out.println("接收请求3" );
        return "{\"id\":1,\"name\":\"文杰\"}";
    }

    }

