package com.lyx.util;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/2
 * @desc R类是用于前后端交互, 返回json时固定格式
 *  命名为R,是随意的,只不过有几个常见命名
 *  R,ResultObject,ReturnObject
 */
public class R {
    /**
     * code,指状态码,
     *     随意定,20000 是正确,40000 错误
     *     50000 请求超时
     *     60000 没有权限
     * msg,指信息描述
     * data,返回的数据
     */
    private int code;
    private String msg;
    private Object data;


    public static R ok(){
        R r = new R( );
        r.setCode(20000);
        r.setMsg("成功");
        return r;
    }

    public static R ok(Object data){
        R r = new R( );
        r.setCode(20000);
        r.setMsg("成功");
        r.setData(data);
        return r;
    }


    public static R fail(){
        R r = new R( );
        r.setCode(40000);
        r.setMsg("失败");
        return r;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
