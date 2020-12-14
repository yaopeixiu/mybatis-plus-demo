package com.ypx.mybatisplusdemo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 23947
 * @title: ApiResult
 * @projectName kanqiu
 * @description: TODO
 * @date 2020/09/1518:55
 */
@Data
public class ApiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private Object data;

    public static ApiResult success() {
        return resultData(ApiCode.SUCCESS.key, ApiCode.SUCCESS.msg, null);
    }

    public static ApiResult success(Object data) {
        return resultData(ApiCode.SUCCESS.key, ApiCode.SUCCESS.msg, data);
    }

    public static ApiResult matchSuccess(Object data) {
        return resultData(ApiCode.MATCHSUCCESS.key, ApiCode.SUCCESS.msg, data);
    }

    public static ApiResult success(Object data, String msg) {
        return resultData(ApiCode.SUCCESS.key, msg, data);
    }

    public static ApiResult fail(ApiCode apiCode) {
        return resultData(apiCode.key, apiCode.msg, null);
    }

    public static ApiResult fail(String msg) {
        return resultData(ApiCode.PARAM_ERR.key, msg, null);
    }

    public static ApiResult fail(String code, String msg) {
        return resultData(code, msg, null);
    }

    public static ApiResult fail(String code, String msg, Object data) {
        return resultData(code, msg, data);
    }

    private static ApiResult resultData(String code, String msg, Object data) {
        ApiResult resultData = new ApiResult();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
}
