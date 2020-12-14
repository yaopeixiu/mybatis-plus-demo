package com.ypx.mybatisplusdemo.vo;

public enum ApiCode {

//    enum实例
    SUCCESS("200", "成功"),

    MATCHSUCCESS("100", "成功"),

    PARAM_ERR("400", "参数错误");

//    成员变量
    public String key;
    public String msg;

//    构造方法
    ApiCode(String key, String msg){
        this.key = key;
        this.msg = msg;
    }
}
