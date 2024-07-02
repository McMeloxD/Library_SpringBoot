package com.lyx.controller;

import com.lyx.model.User;
import com.lyx.util.R;
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
        System.out.println("接收请求1");
        return "ok.html";
    }

    // @RequestMapping(value = "/req2",method = RequestMethod.GET)
    @GetMapping("/req2")
    public String test2() {
        System.out.println("接收请求2");
        return "ok.html";
    }

    // @RequestMapping(value = "/req2",method = RequestMethod.GET)
    @GetMapping("/json")
    @ResponseBody
    public String test3() {
        System.out.println("接收请求3");
        return "{\"id\":1,\"name\":\"文杰\"}";
    }

    /**
     * 演示5: 统一json格式,返回R
     */
    @GetMapping("/json5")
    @ResponseBody
    public R json5(){
        // 模拟登录成功,返回一个对象
        // R r = new R( );
        // r.setCode(2000);
        // r.setMsg("登录成功");
        // r.setData(new User());

        // 模拟查询全部,
        // R r = new R( );
        // r.setCode(2000);
        // r.setMsg("查询全部数据成功");
        // ArrayList<String> list = new ArrayList<String>( );
        // list.add("北京");
        // list.add("上海");
        // list.add("广州");
        // r.setData(list);

        // 现在发现,因为要同一格式返回,所以每次返回都需要设置R对象,以及其属下,很麻烦
        // 想办法简化! 提取成工具方法
        return R.ok(new User("wenjie","123456"));
    }

}

