package com.lyx.controller;

import com.lyx.model.User;
import com.lyx.util.R;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Controller
public class TestMybatis {
    /**
     * 演示1: 接收简单常见类型(int,double,String,Date)
     * 接收数据,只需要在方法参数列表设置参数即可
     *   参数名要与前端name值一致
     *   数据类型正常写
     * -------------------------------
     * 特殊的,日期默认无法直接绑定,需要额外处理
     *  @DateTimeFormat(pattern = "yyyy-MM-dd")
     */
    @GetMapping("/receiveSimple")
    public String receiveSimple(String username,
                                int age,
                                double score,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("birthday = " + birthday);

        return "ok.html";
    }

    /**
     * 用List接收默认不支持,需要在参数前使用注解@RequestParam
     */
    @GetMapping("/receiveArray")
    public String receiveArray(int[] ids) {
        System.out.println("ids = " + Arrays.toString(ids ));
        return "ok.html";
    }
    /**
     * 用List接收默认不支持,需要在参数前使用注解@RequestParam
     */
    @GetMapping("/receiveList")
    public String receiveList(@RequestParam List<Integer> ids) {
        System.out.println("ids = " + ids);
        return "ok.html";
    }

    /**
     * 用Map接收默认不支持,需要在参数前使用注解@RequestParam
     */
    @GetMapping("/receiveMap")
    public String receiveMap(@RequestParam HashMap<String,String> map) throws ParseException {
        System.out.println("map = " + map);
        /**
         * map中,键是前端的name,值是输入框的值
         * 值都是String类型,如果后续要用,还需要解析成对应的数据类型
         */
        String username = (String) map.get("username");
        int age = Integer.parseInt(map.get("age"));
        double score = Double.parseDouble(map.get("score"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(map.get("birthday"));

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("birthday = " + birthday);
        return "ok.html";
    }

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
    /**
     * 演示请求域,会话域的使用
     * 方法的参数列表中直接定义该变量即可
     */
    @GetMapping("/reqse")
    public String test(HttpServletRequest req, HttpSession session) {

        req.setAttribute("reqKey","reqValue");
        session.setAttribute("seKey","seValue");

        // return "forward:/reqse2";
        return "redirect:/reqse2";
    }


    @GetMapping("/reqse2")
    public String test2(HttpServletRequest req, HttpSession session) {

        Object reqKey = req.getAttribute("reqKey");
        Object seKey = session.getAttribute("seKey");
        System.out.println("reqKey = " + reqKey);
        System.out.println("seKey = " + seKey);

        return "ok.html";
    }

    @PostMapping("/putMessage{content}")
    public String test3(@PathVariable String content) {


        return "ok.html";
    }

    /**
     * 接收路径中的数据
     * 这种是RESTful风格,这种开发是需要返回JSON数据的
     * 即不能跳转/返回页面,需要返回JSON数据
     * 需要将返回值设置成json格式,设置注解@ResponseBody即可返回json数据
     */
    @GetMapping("/blog/{wxid}/article/details/{aid}")
    @ResponseBody
    public String receivePathVariable(@PathVariable String wxid, @PathVariable String aid){
        System.out.println("wxid = " + wxid);
        System.out.println("aid = " + aid);
        return "{code:200,msg:\"信息\"}";
    }
}

